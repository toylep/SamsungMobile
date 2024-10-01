package ru.toylep.samsungmobile.domain.states

import ru.toylep.samsungmobile.domain.models.Task

sealed class TaskState{
    data object Loading : TaskState()
    data class Success(val data: Task) : TaskState()
    data class Error(val message: String) : TaskState()
}

sealed class TaskListState{
    data object Loading : TaskListState()
    data class Success(val data: List<Task>) : TaskListState()
    data class Error(val message: String) : TaskListState()
}