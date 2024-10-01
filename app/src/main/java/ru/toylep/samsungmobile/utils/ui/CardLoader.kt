package ru.toylep.samsungmobile.utils.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.toylep.samsungmobile.R
import ru.toylep.samsungmobile.domain.models.Task
import ru.toylep.samsungmobile.domain.states.ProjectListState
import ru.toylep.samsungmobile.domain.states.TaskListState
import ru.toylep.samsungmobile.domain.states.TaskState
import ru.toylep.samsungmobile.ui.components.tasks.TaskCard
import ru.toylep.samsungmobile.utils.domain.ModelState


@Composable
fun <T> CardLoader(
    state: Any,
    card: @Composable (obj: T) -> Unit,
){
    when (state) {
        is ModelState.Success -> {
            val currentTask = state.data as List<T>
            LazyColumn(modifier = Modifier) {
                items(currentTask) {
                    var data = it as T
                    card(data)
                }
            }
        }
        is ModelState.Loading -> {
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
        is ModelState.Error -> {
            Text(text = state.message)
        }
    }
}