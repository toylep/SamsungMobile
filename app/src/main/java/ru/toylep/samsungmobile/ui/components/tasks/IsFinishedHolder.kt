package ru.toylep.samsungmobile.ui.components.tasks

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun IsFinishedHolder(isFinished: Boolean){
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (isFinished) Color.Green else Color.Red,
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomEnd = 0.dp,
            bottomStart = 10.dp
        )
    ){
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            if (isFinished) Text(text = "Finished") else Text(text = "Unfinished")

        }
    }
}