package ru.toylep.samsungmobile.domain.repository

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import ru.toylep.samsungmobile.domain.models.AddProjectDTO
import ru.toylep.samsungmobile.domain.models.Project
import ru.toylep.samsungmobile.domain.models.ProjectsTasks

interface ProjectRepository{
    @GET("/api/project/list")
    suspend fun getProjects(): Response<List<Project>>
    @GET("/api/project/list")
    suspend fun getProjectsByPerson(@Query("created_by") userID:Int ): Response<List<Project>>
    @GET("/api/project/{id}")
    suspend fun getProjectsById(@Path("id") id: Int): Response<Project>
    @GET("/api/project/tasks")
    suspend fun getProjectTasks(@Query("created_by") userID: Int): Response<List<ProjectsTasks>>
    @DELETE("/api/project/{id}")
    suspend fun deleteProject(@Path("id") id:Int): Response<Unit>
    @POST("/api/project")
    suspend fun addProject(@Body project: AddProjectDTO): Response<Unit>
}