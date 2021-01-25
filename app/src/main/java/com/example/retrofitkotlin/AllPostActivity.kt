package com.example.retrofitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_all_post.*
import kotlinx.android.synthetic.main.activity_main.*

class AllPostActivity : AppCompatActivity() {

    lateinit var viewModel: PostViewModel
      private val postAdapter by lazy { PostAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_post)

        setUpPostRecyclerView()

        val postRepo = Repository()
        val viewModelFactory = PostViewModelFactory(postRepo)
        viewModel = ViewModelProvider(this,viewModelFactory).get(PostViewModel::class.java)
        showButton.setOnClickListener {
            val postNo: String = postIdText.text.toString()
            viewModel.getCustomPost(Integer.parseInt(postNo))
            viewModel.customPostResponse.observe(this, Observer { response ->
                if (response.isSuccessful){
                    response.body()?.let { postAdapter.setData(it) }
                }else{
                    Toast.makeText(this,response.code(),Toast.LENGTH_SHORT).show()
                }
            })
        }

    }

    private fun setUpPostRecyclerView(){
        postRecyclerView.adapter = postAdapter
        postRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}