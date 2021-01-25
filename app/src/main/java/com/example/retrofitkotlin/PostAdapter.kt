package com.example.retrofitkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_row.view.*

class PostAdapter(): RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    private var post = emptyList<Post>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        holder.itemView.postId.text = post[position].id.toString()
        holder.itemView.userId.text = post[position].userId.toString()
        holder.itemView.userTitle.text = post[position].title
        holder.itemView.userBody.text = post[position].body
    }

    override fun getItemCount(): Int {
        return post.size
    }

    fun setData(newList: List<Post>){
        post = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    }
}