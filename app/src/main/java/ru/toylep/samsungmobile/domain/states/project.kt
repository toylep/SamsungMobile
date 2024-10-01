package ru.toylep.samsungmobile.domain.states

import ru.toylep.samsungmobile.domain.models.Project
import ru.toylep.samsungmobile.domain.models.ProjectsTasks

open class ProjectState{
    object Loading : ProjectState()
    data class Success(val data: Project) : ProjectState()
    data class Error(val message: String) : ProjectState()
}

open class ProjectListState{
    object Loading : ProjectListState()
    data class Success(val data: List<Project>) : ProjectListState()
    data class Error(val message: String) : ProjectListState()
}

open class ProjectTaskListState{
    object Loading : ProjectTaskListState()
    data class Success(val data: List<ProjectsTasks>) : ProjectTaskListState()
    data class Error(val message: String) : ProjectTaskListState()
}