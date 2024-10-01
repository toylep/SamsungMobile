package ru.toylep.samsungmobile.ui.components.auth

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.toylep.samsungmobile.domain.models.AuthDTO
import ru.toylep.samsungmobile.domain.services.LocalStorage
import ru.toylep.samsungmobile.domain.services.viewmodels.UserViewModel

@Composable
fun AuthForm(
    localStorage: LocalStorage,
    navController: NavController
) {
    val viewModel: UserViewModel = viewModel()
    var usernameState by remember { mutableStateOf("") }
    var passwordState by remember { mutableStateOf("") }
    val account by viewModel.account.collectAsState()
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = usernameState,
            onValueChange = {
                usernameState = it
            },
            label = { Text(text = "username") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = passwordState,
            label = { Text(text = "password") },
            onValueChange = { passwordState = it },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            viewModel.authUser(AuthDTO(username = usernameState, password = passwordState))
        }) {
            Text(text = "Auth")
        }
    }
    LaunchedEffect(account) {
        Log.i("auth", account.toString())
        account?.let {
            localStorage.saveUser(it)
            navController.navigate("Main")
            Log.i("userView user", localStorage.getUser().toString())
        }
    }
}

