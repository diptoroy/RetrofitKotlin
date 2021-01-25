package com.example.retrofitkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.load.engine.bitmap_recycle.IntegerArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        //viewModel.getPost()

//        viewModel.postResponse.observe(this, Observer { response ->
//            if (response.isSuccessful) {
//                Log.d("Response", response.body()?.userId.toString())
//                Log.d("Response", response.body()?.title.toString())
//                 Log.d("Response", response.body()?.body.toString())
//
//                name.text = response.body()?.title!!.toString()
//
//            } else {
//                Log.d("Response", response.errorBody().toString())
//                name.text = response.code().toString()
//            }
//        })

        showBtn.setOnClickListener {
            val intent = Intent(applicationContext,AllPostActivity::class.java)
            startActivity(intent)
        }

        val option:HashMap<String,String>  = HashMap()
        option["_sort"] = "id"
        option["_order"] = "desc"


        postButton.setOnClickListener {
            val postNo: String = editId.text.toString()
            viewModel.getCustomQueryMap(Integer.parseInt(postNo),option)
            viewModel.customQueryResponseMap.observe(this, Observer { response ->
                if (response.isSuccessful) {
//                    Log.d("Response", response.body()?.userId.toString())
//                    Log.d("Response", response.body()?.title.toString())
//                    Log.d("Response", response.body()?.body.toString())
                    response.body()?.forEach {
                        Log.d("Response", it.userId.toString())
                        Log.d("Response", it.id.toString())
                        Log.d("Response", it.title)
                        Log.d("Response", it.body)
                        Log.d("Response", "***************")
                    }
                    name.text = response.body()?.toString()

                } else {
//                    Log.d("Response", response.errorBody().toString())
                    name.text = response.code().toString()
                }
            })
        }
    }
}