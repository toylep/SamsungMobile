package ru.toylep.samsungmobile.ui.components.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.toylep.samsungmobile.domain.models.Task
import ru.toylep.samsungmobile.domain.services.viewmodels.TaskViewModel
import ru.toylep.samsungmobile.utils.ui.SquaredButton
import ru.toylep.samsungmobile.utils.ui.cardTextModifier


@Composable
fun TaskCard(
    viewModel: TaskViewModel,
    task: Task,
) {
    var finishedState by remember { mutableStateOf(task.isFinished) }
    var isHidden by remember { mutableStateOf(false) }
    if (!isHidden){
        Spacer(modifier = Modifier.height(4.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(task.name, fontSize = 18.sp, modifier = cardTextModifier)
                    IsFinishedHolder(finishedState)
                }
                Text(
                    "Проект: ${task.project.name}",
                    fontSize = 18.sp,
                    modifier = cardTextModifier
                )
                Text(
                    "Дедлайн: ${task.deadline}",
                    modifier = cardTextModifier
                )
                Text(
                    task.description,
                    modifier = cardTextModifier.height(50.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), // Добавляем отступы между кнопками и краем карточки
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SquaredButton(
                    modifier = Modifier
                        .weight(1f),
                    onClick = {
                        viewModel.finishTask(
                            taskID = task.id,
                            isFinished = !task.isFinished
                        )
                        finishedState = !finishedState
                    },
                ) {
                    Text(text = "Finish")
                }
                SquaredButton(
                    modifier = Modifier
                        .weight(1f),
                    onClick = {
                        viewModel.deleteTask(task.id)
                        isHidden = true
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color.Red
                    )
                ) {
                    Text(text = "Decline")
                }
            }
        }
    }
}

