package ru.toylep.samsungmobile.ui.components.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.toylep.samsungmobile.domain.models.User
import ru.toylep.samsungmobile.utils.ui.BigHeader
import ru.toylep.samsungmobile.utils.ui.FormText

@Composable
fun UserCard(user: User, fontSize:Int, isPersonal:Boolean = true) {
    Column(modifier = Modifier.fillMaxWidth()) {

        Row(horizontalArrangement = Arrangement.Center) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(4.dp)
            ) {
                if (isPersonal) {
                    BigHeader(text = "User Info")
                    Divider()
                }
                FormText(text = "Email: ${user.email}",fontSize = fontSize )
                FormText(text = "Username: ${user.username}",fontSize = fontSize)
                FormText(text = "First Name: ${user.firstName}",fontSize = fontSize)
                FormText(text = "Last Name: ${user.lastName}",fontSize = fontSize)
            }
        }
    }
}