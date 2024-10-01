package ru.toylep.samsungmobile.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.toylep.samsungmobile.domain.services.LocalStorage
import ru.toylep.samsungmobile.ui.theme.SamsungMobileTheme


@Composable
fun MainView() {
    val localStorage = LocalStorage(LocalContext.current)
    val user by remember {
        mutableStateOf(localStorage.getUser())
    }
    val upperNavController = rememberNavController()
    SamsungMobileTheme {
        NavHost(
            navController = upperNavController,
            startDestination =  if (user != null) "Main" else "Auth"
        ) {
            composable("Main") { MainContent() }
            composable("Auth") { AuthView(localStorage = localStorage, upperNavController) }
        }
    }
}