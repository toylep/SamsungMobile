package ru.toylep.samsungmobile.domain.services

import android.content.Context
import ru.toylep.samsungmobile.config.gson
import ru.toylep.samsungmobile.domain.models.User

class LocalStorage(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    private val key = "user"

    fun saveUser(user: User) {
        val strAccount =  gson.toJson(user)
        sharedPreferences.edit().putString(key, strAccount).apply()
    }
    fun getUser(): User? = gson.fromJson(
        sharedPreferences.getString(key, null),
        User::class.java
    ) ?: null


    fun deleteUser() = sharedPreferences.edit().remove(key).apply()

}