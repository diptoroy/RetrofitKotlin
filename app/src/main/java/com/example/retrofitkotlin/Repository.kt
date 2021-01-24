package com.example.retrofitkotlin

import retrofit2.Response

class Repository {
    suspend fun getEmployeeData():Response<Employee>{
        return ApiClient.api.getEmployeeData()
    }
}