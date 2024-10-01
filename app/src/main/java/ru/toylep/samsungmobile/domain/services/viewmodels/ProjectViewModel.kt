package ru.toylep.samsungmobile.domain.services.viewmodels

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.toylep.samsungmobile.config.getRetrofit
import ru.toylep.samsungmobile.domain.models.AddProjectDTO
import ru.toylep.samsungmobile.domain.models.User
import ru.toylep.samsungmobile.domain.repository.ProjectRepository
import ru.toylep.samsungmobile.domain.states.ProjectListState
import ru.toylep.samsungmobile.utils.domain.CustomViewModel


class ProjectViewModel: CustomViewModel() {
    override val logTag: String = "projectVM"

    val repo: ProjectRepository = getRetrofit().create(ProjectRepository::class.java)
    private val _projectList = MutableStateFlow<ProjectListState>(ProjectListState.Loading)
    val projectList: StateFlow<ProjectListState> = _projectList.asStateFlow()


    fun getProjects(user: User? = null) {
        viewModelLaunch {
            val projects = repo.getProjects().body()!!
            _projectList.value = ProjectListState.Success(projects)
        }
    }

    fun deleteProject(id:Int){
        viewModelLaunch {
            val resp = repo.deleteProject(id)
        }
    }

    fun addProject(project: AddProjectDTO){
        viewModelLaunch {
            repo.addProject(project)
        }
    }

}