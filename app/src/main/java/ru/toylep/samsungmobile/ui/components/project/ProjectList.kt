package ru.toylep.samsungmobile.ui.components.project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.toylep.samsungmobile.R
import ru.toylep.samsungmobile.domain.services.LocalStorage
import ru.toylep.samsungmobile.domain.services.viewmodels.ProjectViewModel
import ru.toylep.samsungmobile.domain.states.ProjectListState
import ru.toylep.samsungmobile.utils.ui.GifImage


@Composable
fun ListOfProjects() {
    val service: ProjectViewModel = viewModel()
    val userID = LocalStorage(LocalContext.current).getUser()!!.id

    val showDialog = remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        service.getProjects()
    }
    val projectState: ProjectListState by service.projectList.collectAsState()

    when(val state = projectState) {
        is ProjectListState.Success -> {
            LazyColumn(modifier = Modifier) {
                items(state.data){
                    ProjectCard(project = it,userID)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
        is ProjectListState.Loading -> {
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
        is ProjectListState.Error -> {
            Text(text = state.message)
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier,
            onClick = { showDialog.value = !showDialog.value },
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null )
        }
    }
    if (showDialog.value) {
        AddProjectDialog(showDialog = showDialog, userID = userID)
    }

}
