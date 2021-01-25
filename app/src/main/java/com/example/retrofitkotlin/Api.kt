package com.example.retrofitkotlin

import retrofit2.Response
import retrofit2.http.GET

public interface Api {

    @GET("api/v1/employee/1")
    suspend fun getEmployeeData():Response<Employee>

    @GET("posts/1")
    suspend fun getPost():Response<Post>
}