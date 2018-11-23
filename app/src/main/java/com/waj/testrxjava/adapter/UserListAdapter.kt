package com.waj.testrxjava.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.waj.testrxjava.R
import com.waj.testrxjava.activity.RetrofitActivity

//import com.bumptech.glide.Glide

class UserListAdapter(val callback: RetrofitActivity.UserClickCallback) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>(){
    val mUsers = mutableListOf<GitHubUser>()

    fun addUser(user: GitHubUser) {
        mUsers.add(user)
        notifyItemInserted(mUsers.size-1) //更新最后一位
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): UserViewHolder {
        val item = LayoutInflater.from(p0.context)
            .inflate(R.layout.item_network_user,p0,false)
        return UserViewHolder(item)
    }

    override fun getItemCount(): Int {
        return mUsers.size
    }

    override fun onBindViewHolder(p0: UserViewHolder, p1: Int) {
        p0.bindTo(mUsers[p1])
    }


    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivUserPicture = itemView.findViewById<ImageView>(R.id.ivUserPicture)
        val tvUserName = itemView.findViewById<TextView>(R.id.tvUserName)
        val tvUserLogin = itemView.findViewById<TextView>(R.id.tvUserLogin)
        val tvUserPage = itemView.findViewById<TextView>(R.id.tvUserPage)

        init {
            itemView.setOnClickListener { callback.onItemClicked(tvUserLogin.text.toString()) }
        }

        fun bindTo(user: GitHubUser) {
            tvUserName.text = user.name
            tvUserLogin.text = user.login
            tvUserPage.text = user.repos_url
//            Glide.with(ivUserPicture).load(user.avatarUrl).into(ivUserPicture)
        }
    }

    class GitHubUser{
        var login: String?=null
        var avatar_url: String?=null
        var name: String? = null
        var repos_url: String? = null
    }
}