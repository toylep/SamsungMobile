package ru.toylep.samsungmobile.domain.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Project(
    val id: Int,
    val name:String,
    val description:String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("created_by")
    val createdBy: User
)

data class AddProjectDTO(
    val name:String,
    val description:String,
    @SerializedName("created_by")
    val createdBy: Int
)

data class ProjectsTasks(
    val id: Int,
    val name: String,
    val tasks: List<TaskWithUser>,
    @SerializedName("created_by")
    val createdBy: Int,
)
