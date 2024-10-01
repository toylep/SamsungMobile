package ru.toylep.samsungmobile.ui.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.toylep.samsungmobile.ui.components.BottomNav
import ru.toylep.samsungmobile.ui.components.profile.ProfileCard
import ru.toylep.samsungmobile.ui.components.project.ListOfProjects
import ru.toylep.samsungmobile.ui.components.tasks.TaskList


@SuppressLint("StateFlowValueCalledInComposition", "RestrictedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Task Tracker") }) },
        bottomBar = { BottomNav(navController) },
    ) {
        Surface(
            modifier = Modifier
                .padding(
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding()
                )
        ) {
            NavHost(navController = navController, startDestination = "ProjectPool") {
                composable("ProjectPool") { ListOfProjects() }
                composable("Tasks") { TaskList() }
                composable("Profile") { ProfileCard() }
            }
        }
    }
}







