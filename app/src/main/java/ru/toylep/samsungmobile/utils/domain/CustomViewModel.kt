package ru.toylep.samsungmobile.utils.domain

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.math.log

abstract class CustomViewModel: ViewModel() {
    protected abstract val logTag:String

    fun viewModelLaunch(
        func:suspend ()->Unit,
    ) {
        viewModelScope.launch {
            try {
                func()
            } catch (e: Exception) {
                Log.i(logTag, e.message!!)
            }
        }
    }
}