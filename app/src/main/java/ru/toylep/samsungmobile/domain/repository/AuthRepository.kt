package ru.toylep.samsungmobile.domain.repository

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ru.toylep.samsungmobile.domain.models.AddUserDTO
import ru.toylep.samsungmobile.domain.models.User
import ru.toylep.samsungmobile.domain.models.AuthDTO

interface AuthRepository {
    @POST("/api/auth/")
    suspend fun authUser(@Body dto: AuthDTO): Response<User>
    @POST("/api/auth/register")
    suspend fun registerUser(@Body user: AddUserDTO): Response<Unit>
}