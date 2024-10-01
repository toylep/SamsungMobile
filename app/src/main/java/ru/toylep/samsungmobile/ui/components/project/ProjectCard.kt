package ru.toylep.samsungmobile.ui.components.project

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.toylep.samsungmobile.domain.models.Project
import ru.toylep.samsungmobile.domain.services.viewmodels.ProjectViewModel
import ru.toylep.samsungmobile.ui.components.profile.UserCard
import ru.toylep.samsungmobile.utils.ui.BigHeader
import ru.toylep.samsungmobile.utils.ui.SquaredButton
import ru.toylep.samsungmobile.utils.ui.cardTextModifier


@Composable
fun ProjectCard(
    project: Project,
    userID: Int,
) {
    var viewModel: ProjectViewModel = viewModel()
    val textModifier = cardTextModifier
    var showPopup = remember { mutableStateOf(false) }
    var showDialog = remember { mutableStateOf(false) }
    var isHiddenState by remember { mutableStateOf(false) }
    if (!isHiddenState) {
        Spacer(modifier = Modifier.height(4.dp))
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(project.name, fontSize = 18.sp, modifier = textModifier)
                if (project.createdBy.id == userID) {
                    Button(
                        modifier = Modifier.padding(horizontal = 2.dp).height(30.dp).width(30.dp),
                        contentPadding = PaddingValues(0.dp),
                        onClick = {
                            isHiddenState = true
                            viewModel.deleteProject(project.id)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        shape = RoundedCornerShape(4.dp),
                    ) {
                        Icon(Icons.Default.Clear, contentDescription = null)
                    }
                }
            }
            Text(text = project.createdAt.toString(), fontSize = 12.sp, modifier = textModifier)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                project.description,
                modifier = textModifier.height(50.dp)
            )
//        Divider()
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { showPopup.value = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text(text = project.createdBy.username, textModifier, color = Color.Blue)
                }
                Button(
                    modifier = Modifier
                        .padding(4.dp),
                    contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
                    shape = RoundedCornerShape(10.dp),
                    content = {
                        Text("Add task")
                    },
                    onClick = { showDialog.value = true }
                )
            }

            if (showDialog.value) {
                AddTaskDialog(
                    showDialog, projectID = project.id
                )
            }

            if (showPopup.value) {
                UserCardDialog(showPopup, project.createdBy)
            }
        }
    }
}



    
