package com.example.retrofitkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {

    val postResponse:MutableLiveData<Response<Post>> = MutableLiveData()
    val post2Response:MutableLiveData<Response<Post>> = MutableLiveData()
    val customPostResponse:MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val customQueryResponse:MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val customQueryResponseMap:MutableLiveData<Response<List<Post>>> = MutableLiveData()

//    fun getPost(){
//        viewModelScope.launch {
//            val pResponse = repository.getPost()
//            postResponse.value = pResponse
//        }
//    }

    fun getPost2(number: Int){
        viewModelScope.launch {
            val pResponse = repository.getPost2(number)
            post2Response.value = pResponse
        }
    }

    fun getCustomPost(userId: Int){
        viewModelScope.launch {
            val customResponse = repository.getCustomPost(userId)
            customPostResponse.value = customResponse
        }
    }

    fun getCustomQuery(userId: Int,sort: String,order: String){
        viewModelScope.launch {
            val customQuery = repository.getCustomQuery(userId,sort,order)
            customQueryResponse.value = customQuery
        }
    }

    fun getCustomQueryMap(userId: Int,option:Map<String,String>){
        viewModelScope.launch {
            val customQueryMap = repository.getCustomQueryMap(userId,option)
            customQueryResponseMap.value = customQueryMap
        }
    }
}