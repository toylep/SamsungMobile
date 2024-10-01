package ru.toylep.samsungmobile.ui.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.toylep.samsungmobile.domain.services.LocalStorage
import ru.toylep.samsungmobile.ui.components.auth.AuthForm
import ru.toylep.samsungmobile.ui.components.auth.RegistrationForm

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AuthView(
    localStorage: LocalStorage,
    navController: NavController) {
    var hasRegistered by remember {
        mutableStateOf(true)
    }
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Task Tracker") }) }
    ) {
        Surface(modifier = Modifier
            .padding(top = it.calculateTopPadding() + 5.dp)) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if (hasRegistered) {
                    Text(text = "Authentication", style = MaterialTheme.typography.titleLarge)
                    Divider()
                    AuthForm(localStorage = localStorage,navController = navController)
                    Button(onClick = { hasRegistered = !hasRegistered }) {
                        Text(text = "Has no account?")
                    }
                } else {
                    Text(text = "Registration", style = MaterialTheme.typography.titleLarge)
                    Divider()
                    RegistrationForm()
                    Button(onClick = { hasRegistered = !hasRegistered }) {
                        Text(text = "Already has account?")
                    }
                }
            }

        }
    }
}

