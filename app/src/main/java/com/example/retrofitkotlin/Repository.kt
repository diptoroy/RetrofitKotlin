package com.example.retrofitkotlin

import retrofit2.Response

class Repository {
    suspend fun getPost():Response<Post>{
        return ApiClient.api.getPost()
    }

    suspend fun getPost2(number: Int):Response<Post>{
        return ApiClient.api.getPost2(number)
    }

    suspend fun getCustomPost(userId: Int):Response<List<Post>>{
        return ApiClient.api.getCustomPost(userId)
    }

    suspend fun getCustomQuery(userId: Int,sort: String,order: String):Response<List<Post>>{
        return ApiClient.api.getCustomQuery(userId,sort,order)
    }

    suspend fun getCustomQueryMap(userId: Int,option:Map<String,String>):Response<List<Post>>{
        return ApiClient.api.getCustomQueryMap(userId,option)
    }
}