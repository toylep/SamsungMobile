package ru.toylep.samsungmobile.utils.ui

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(datePickerState: DatePickerState){
    DatePicker(
        modifier = Modifier.heightIn(max = 100.dp),
        state = datePickerState,
        headline = null,
        title = null,
        showModeToggle = false
    )
}