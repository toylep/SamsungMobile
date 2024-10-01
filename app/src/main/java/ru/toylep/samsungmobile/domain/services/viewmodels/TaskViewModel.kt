package ru.toylep.samsungmobile.domain.services.viewmodels

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.toylep.samsungmobile.config.getRetrofit
import ru.toylep.samsungmobile.domain.models.AddedTask
import ru.toylep.samsungmobile.domain.models.Project
import ru.toylep.samsungmobile.domain.models.User
import ru.toylep.samsungmobile.domain.repository.TaskRepository
import ru.toylep.samsungmobile.domain.states.TaskListState
import ru.toylep.samsungmobile.utils.domain.CustomViewModel

class TaskViewModel: CustomViewModel() {
    override val logTag = "taskVM"

    val repo: TaskRepository = getRetrofit().create(TaskRepository::class.java)

    private var _taskList = MutableStateFlow<TaskListState>(TaskListState.Loading)
    var taskList = _taskList.asStateFlow()

    fun deleteTask(id:Int) {
        viewModelLaunch {
            repo.deleteTask(id)
        }
    }

    fun finishTask(taskID:Int,isFinished: Boolean){
        viewModelLaunch{
            repo.finishTask(taskID, mutableMapOf("is_finished" to isFinished))
        }
    }

    fun addTask(task: AddedTask){
        viewModelLaunch {
            val res = repo.addTask(task)
        }
    }

    fun getTasksByUser(user: User){
        viewModelLaunch {
            val tasks = repo.getByUser(user.id).body()!!
            _taskList.value = TaskListState.Success(tasks)
        }
    }

    fun getTasksByProject(project: Project){
        viewModelLaunch {
            val tasks = repo.getTaskByProject(project.id).body()!!
            _taskList.value = TaskListState.Success(tasks)
        }
    }
}