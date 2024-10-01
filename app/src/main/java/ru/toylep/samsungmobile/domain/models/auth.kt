package ru.toylep.samsungmobile.domain.models

import com.google.gson.annotations.SerializedName


data class AuthDTO(
    var username: String,
    var password: String
)

data class AddUserDTO(
    val email: String,
    val username: String,
    val password: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String
)

data class User(
    val id: Int,
    val email: String,
    val username: String,
    val password: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String
)