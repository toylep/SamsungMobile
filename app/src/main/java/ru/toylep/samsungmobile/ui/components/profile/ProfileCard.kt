package ru.toylep.samsungmobile.ui.components.profile

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.toylep.samsungmobile.domain.models.Project
import ru.toylep.samsungmobile.domain.services.LocalStorage
import ru.toylep.samsungmobile.ui.components.project.ProjectCard
import ru.toylep.samsungmobile.utils.restart
import ru.toylep.samsungmobile.utils.ui.BigHeader
import ru.toylep.samsungmobile.utils.ui.SquaredButton


@Composable
fun ProfileCard() {
    val context = LocalContext.current
    val localStorage = LocalStorage(context)
    val user = localStorage.getUser()!!
    Column{
        BigHeader(text = "My Profile")
        UserCard(user = user, fontSize = 20, isPersonal = false)
        Row(horizontalArrangement = Arrangement.Center) {
            Button(
                modifier = Modifier
                    .padding(4.dp)
                    .border(
                        width = 2.dp,
                        color = Color.Red,
                        shape = RoundedCornerShape(10.dp)
                    ),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Red),
                onClick = {
                    LocalStorage(context).deleteUser()
                    Thread.sleep(1000)
                    context.restart()
                },
                content = { Text(text = "Logout") },
            )
        }
    }
}

