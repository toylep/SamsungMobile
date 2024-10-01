package ru.toylep.samsungmobile.domain.services.viewmodels

import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.toylep.samsungmobile.config.getRetrofit
import ru.toylep.samsungmobile.domain.models.AddUserDTO
import ru.toylep.samsungmobile.domain.models.AuthDTO
import ru.toylep.samsungmobile.domain.models.User
import ru.toylep.samsungmobile.domain.repository.AuthRepository
import ru.toylep.samsungmobile.utils.domain.CustomViewModel


class UserViewModel: CustomViewModel() {
    override val logTag: String = "userVM"

    val repo = getRetrofit().create(AuthRepository::class.java)
    private val _user = MutableStateFlow<User?>(null)
    val account = _user.asStateFlow()


    fun authUser(dto: AuthDTO) {
        viewModelLaunch {
            _user.value = repo.authUser(dto).body()!!
            Log.i(logTag, repo.authUser(dto).body()!!.email)
        }
    }
    fun registerUser(user: AddUserDTO) {
        viewModelLaunch {
            repo.registerUser(user).body()
        }
    }
}