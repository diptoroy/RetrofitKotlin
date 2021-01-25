package com.example.retrofitkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class PostViewModel(private val postRepo:Repository):ViewModel() {
    val customPostResponse: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getCustomPost(userId: Int){
        viewModelScope.launch {
            val customResponse = postRepo.getCustomPost(userId)
            customPostResponse.value = customResponse
        }
    }
}