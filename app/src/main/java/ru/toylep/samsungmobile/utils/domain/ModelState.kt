package ru.toylep.samsungmobile.utils.domain


abstract class ModelState  {
    data object Loading : ModelState()
    data class Success(val data: Any) : ModelState()
    data class Error(val message: String) : ModelState()
}
