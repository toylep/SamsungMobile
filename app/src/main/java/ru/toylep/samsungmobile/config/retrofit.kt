package ru.toylep.samsungmobile.config

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()

fun getRetrofit(): Retrofit{
    return  Retrofit
        .Builder()
//    .baseUrl("http://192.168.93.53:8000/api")
//    .baseUrl("http://192.168.1.67:8000")
        .baseUrl("http://10.0.2.2:8000")
//    .baseUrl("http://localhost:8000/api")
//    .baseUrl("http://127.0.0.1:8000/api")
//    .baseUrl("http://172.20.10.2:8000/api")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}
