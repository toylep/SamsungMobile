package ru.toylep.samsungmobile.ui.components.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.toylep.samsungmobile.R
import ru.toylep.samsungmobile.domain.services.LocalStorage
import ru.toylep.samsungmobile.domain.services.viewmodels.TaskViewModel
import ru.toylep.samsungmobile.domain.states.TaskListState
import ru.toylep.samsungmobile.utils.ui.GifImage



@Composable
fun TaskList() {
    val taskViewModel: TaskViewModel = viewModel()
    val tasks by taskViewModel.taskList.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        val user = LocalStorage(context).getUser()!!
        taskViewModel.getTasksByUser(user)
    }

    when (val state = tasks) {
        is TaskListState.Success -> {
            var taskList by remember { mutableStateOf(state.data) }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(taskList) {
                    TaskCard(viewModel = taskViewModel,task = it )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
        is TaskListState.Loading -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GifImage(
                    imageID = R.drawable.loading
                )
            }
        }
        is TaskListState.Error -> {
            Text(text = state.message)
        }
    }
}