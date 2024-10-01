package ru.toylep.samsungmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import ru.toylep.samsungmobile.domain.services.LocalStorage
import ru.toylep.samsungmobile.ui.theme.SamsungMobileTheme
import ru.toylep.samsungmobile.ui.views.AuthView
import ru.toylep.samsungmobile.ui.views.MainContent
import ru.toylep.samsungmobile.ui.views.MainView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainView()
        }
    }
}


