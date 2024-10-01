package ru.toylep.samsungmobile.domain.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Task(
    val id: Int,
    val name: String,
    val description: String,
    val deadline: Date,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("created_by")
    val createdBy: Int,
    @SerializedName("project")
    val project: Project,
    @SerializedName("is_finished")
    var isFinished: Boolean,
)

data class TaskWithUser(
    val id: Int,
    val name: String,
    val description: String,
    val deadline: Date,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("created_by")
    val createdBy: User,
    @SerializedName("project")
    val project: Project,
    @SerializedName("is_finished")
    var isFinished: Boolean,
)

data class AddedTask(
    val name:String,
    val description: String,
    val deadline: Date,
    @SerializedName("project")
    val projectID: Int,
    @SerializedName("created_by")
    val userID: Int,
)