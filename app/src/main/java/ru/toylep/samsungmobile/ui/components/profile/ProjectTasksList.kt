package ru.toylep.samsungmobile.ui.components.profile

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import ru.toylep.samsungmobile.R
import ru.toylep.samsungmobile.domain.services.LocalStorage
import ru.toylep.samsungmobile.domain.services.viewmodels.ProjectTaskViewModel
import ru.toylep.samsungmobile.domain.states.ProjectTaskListState
import ru.toylep.samsungmobile.ui.components.project.ProjectTaskCard
import ru.toylep.samsungmobile.utils.ui.GifImage

@Composable
fun ProjectTasksList(
    viewModel: ProjectTaskViewModel = ProjectTaskViewModel()
) {
    val context = LocalContext.current
    val ptState by viewModel.projectList.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getProjectTasks(LocalStorage(context).getUser()!!)
    }

    when(val state = ptState) {
        is ProjectTaskListState.Success -> {
            LazyColumn(modifier = Modifier) {
                items(state.data){
                    ProjectTaskCard(pt = it)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
        is ProjectTaskListState.Loading -> {
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
        is ProjectTaskListState.Error -> {
            Text(text = state.message)
        }
    }
}