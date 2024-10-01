package ru.toylep.samsungmobile.domain.services.viewmodels

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.toylep.samsungmobile.config.getRetrofit
import ru.toylep.samsungmobile.domain.models.User
import ru.toylep.samsungmobile.domain.repository.ProjectRepository
import ru.toylep.samsungmobile.domain.states.ProjectTaskListState
import ru.toylep.samsungmobile.utils.domain.CustomViewModel

class ProjectTaskViewModel: CustomViewModel() {
    override val logTag: String = "projectVM"

    val repo: ProjectRepository = getRetrofit().create(ProjectRepository::class.java)
    private val _projectList = MutableStateFlow<ProjectTaskListState>(ProjectTaskListState.Loading)
    val projectList: StateFlow<ProjectTaskListState> = _projectList.asStateFlow()


    fun getProjectTasks(user: User) {
        viewModelLaunch {
            val projects = repo.getProjectTasks(user.id).body()!!
            _projectList.value = ProjectTaskListState.Success(projects)
        }
    }
}