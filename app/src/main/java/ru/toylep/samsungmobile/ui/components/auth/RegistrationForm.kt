package ru.toylep.samsungmobile.ui.components.auth

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.toylep.samsungmobile.domain.models.AddUserDTO
import ru.toylep.samsungmobile.domain.services.viewmodels.UserViewModel

@Composable
fun RegistrationForm() {

    val context = LocalContext.current
    val viewModel: UserViewModel = viewModel()
    var emailState by remember { mutableStateOf("") }
    var usernameState by remember { mutableStateOf("") }
    var passwordState by remember { mutableStateOf("") }
    var firstNameState by remember { mutableStateOf("") }
    var lastNameState by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = emailState,
            onValueChange = { emailState = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = usernameState,
            onValueChange = { usernameState = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = passwordState,
            onValueChange = { passwordState = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = firstNameState,
            onValueChange = { firstNameState = it },
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = lastNameState,
            onValueChange = { lastNameState = it },
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            viewModel.registerUser(
                AddUserDTO(
                    email = emailState,
                    firstName = firstNameState,
                    lastName = lastNameState,
                    password = passwordState,
                    username = usernameState,
                )
            )
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Register")
        }
    }
}
