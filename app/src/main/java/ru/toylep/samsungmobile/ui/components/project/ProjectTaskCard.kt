package ru.toylep.samsungmobile.ui.components.project

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.toylep.samsungmobile.domain.models.ProjectsTasks

@Composable
fun ProjectTaskCard(
    pt: ProjectsTasks
){
    var showPopup = remember { mutableStateOf(false) }
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )
    ){
        Text(pt.name)
        for (task in pt.tasks){
            Row {
                Text(text = task.name)
                if (showPopup.value) {
                    UserCardDialog(showPopup, task.createdBy)
                }
            }
        }
    }
}