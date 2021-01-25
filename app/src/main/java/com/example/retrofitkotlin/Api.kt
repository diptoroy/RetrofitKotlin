package com.example.retrofitkotlin

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

public interface Api {

    @GET("posts/1")
    suspend fun getPost():Response<Post>

    //path select
    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number:Int)
    :Response<Post>

    //query
    @GET("posts")
    suspend fun getCustomPost(
        @Query("userId") userId: Int
    ):Response<List<Post>>

    //multipleQuery
    @GET("posts")
    suspend fun getCustomQuery(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ):Response<List<Post>>

    //QueryMap
    @GET("posts")
    suspend fun getCustomQueryMap(
        @Query("userId") userId: Int,
        @QueryMap option:Map<String,String>
    ):Response<List<Post>>
}