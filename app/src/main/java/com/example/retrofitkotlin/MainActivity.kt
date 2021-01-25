package com.example.retrofitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        //viewModel.getEmployeeData()
        viewModel.getPost()

//        viewModel.repoResponse.observe(this, Observer { response ->
//            if (response.isSuccessful) {
//                Log.d("Response", response.body()?.employee_id.toString())
//                Log.d("Response", response.body()?.employee_name.toString())
//                Log.d("Response", response.body()?.employee_age.toString())
//                Log.d("Response", response.body()?.employee_salary.toString())
//
//                name.text = response.body()?.employee_name
//
//            } else {
//                Log.d("Response", response.errorBody().toString())
//                name.text = response.code().toString()
//            }
//        })

        viewModel.postResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Response", response.body()?.userId.toString())
                Log.d("Response", response.body()?.title.toString())
                Log.d("Response", response.body()?.body.toString())

                name.text = response.body()?.title!!.toString()

            } else {
                Log.d("Response", response.errorBody().toString())
                name.text = response.code().toString()
            }
        })
    }
}