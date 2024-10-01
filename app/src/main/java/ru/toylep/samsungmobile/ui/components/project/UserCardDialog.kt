package ru.toylep.samsungmobile.ui.components.project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import ru.toylep.samsungmobile.domain.models.Project
import ru.toylep.samsungmobile.domain.models.User
import ru.toylep.samsungmobile.ui.components.profile.UserCard
import ru.toylep.samsungmobile.utils.ui.SquaredButton
@Composable
fun UserCardDialog(showPopup: MutableState<Boolean>, user: User) {
    Dialog(
        onDismissRequest = { showPopup.value = false }
    ) {
        Column {
            UserCard(user = user, fontSize = 14)
            Row (horizontalArrangement = Arrangement.Center){
                SquaredButton(
                    modifier = Modifier
                        .height(40.dp)
                        .width(80.dp)
                        .padding(horizontal = 4.dp, vertical = 4.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    onClick = { showPopup.value = false },
                    content = { Icon(Icons.Default.ArrowBack, contentDescription = null) }
                )

            }
        }
    }
}