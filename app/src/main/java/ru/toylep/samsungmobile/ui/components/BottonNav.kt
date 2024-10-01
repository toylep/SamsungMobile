package ru.toylep.samsungmobile.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun BottomNav(
    navController: NavController
){
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(0xffffffff),
        contentColor = MaterialTheme.colorScheme.onSurface,
        content = {
            NavigationBarItem(
                selected =  true ,
                onClick = { navController.navigate("ProjectPool") },
                icon = { Icon(Icons.Default.List, contentDescription = null) },
                label = { Text("Project Pool") }
            )
            NavigationBarItem(
                selected = true,
                onClick = { navController.navigate("Tasks") },
                icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                label = { Text("My Tasks") }
            )
            NavigationBarItem(
                selected = true,
                onClick = { navController.navigate("Profile") },
                icon = { Icon(Icons.Default.Person, contentDescription = null) },
                label = { Text("Profile") }
            )
        }
    )
}