package ru.toylep.samsungmobile.domain.repository

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import ru.toylep.samsungmobile.domain.models.AddedTask
import ru.toylep.samsungmobile.domain.models.Task

interface TaskRepository{
    @GET("/api/tasks/list")
    suspend fun getByUser(@Query("created_by") userID:Int): Response<List<Task>>
    @GET("/api/tasks/list")
    suspend fun getTaskByProject(@Query("project") projectID: Int): Response<List<Task>>
    @POST("/api/tasks")
    suspend fun addTask(@Body task: AddedTask): Response<Unit>
    @PATCH("/api/tasks/{id}")
    suspend fun finishTask(@Path("id") id:Int, @Body param:Map<String,Boolean>)
    @DELETE("/api/tasks/{id}")
    suspend fun deleteTask(@Path("id") id:Int)


}
