package ru.toylep.samsungmobile.ui.components.project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.toylep.samsungmobile.domain.models.AddedTask
import ru.toylep.samsungmobile.domain.services.LocalStorage
import ru.toylep.samsungmobile.domain.services.viewmodels.TaskViewModel
import ru.toylep.samsungmobile.utils.ui.BigHeader
import ru.toylep.samsungmobile.utils.ui.CustomDatePicker
import ru.toylep.samsungmobile.utils.ui.SquaredButton
import java.util.Date


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskDialog(
    showDialog: MutableState<Boolean>,
    projectID: Int,

    ) {
    var userID = LocalStorage(LocalContext.current).getUser()!!.id
    val viewModel: TaskViewModel = viewModel()

    var taskNameState by remember { mutableStateOf("") }
    var descriptionState by remember { mutableStateOf("") }
    var datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)

    ModalBottomSheet(
        onDismissRequest = {showDialog.value = false},
        modifier = Modifier.fillMaxHeight(),
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BigHeader(text = "Add Task")
            OutlinedTextField(
                value = taskNameState,
                onValueChange = { taskNameState = it },
                label = { Text(text = "Task Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            OutlinedTextField(
                value = descriptionState,
                onValueChange = { descriptionState = it },
                label = { Text(text = "Description") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(vertical = 8.dp),
                maxLines = 5
            )
        CustomDatePicker(datePickerState)
            SquaredButton(
                onClick = {
                    viewModel.addTask(
                        AddedTask(
                            name = taskNameState,
                            description = descriptionState,
                            deadline = Date(datePickerState.selectedDateMillis!!),
                            projectID = projectID,
                            userID = userID,
                        )
                    )
                    showDialog.value = false
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF008000)),
                modifier = Modifier.fillMaxWidth(),
                content = {
                    Text(
                        text = "Post",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            )
        }
    }
}


