package com.waj.testrxjava

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_retrofit.*

class RetrofitActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = UserListAdapter(object : UserClickCallback{
            override fun onItemClicked(name: String) {
                startActivity(NetWorkDetailActivity.from(this@RetrofitActivity,name))
            }

        })
        NetworkWrapper.getUsersInfo(adapter)
        recyclerView.adapter = adapter

    }

    interface UserClickCallback{
        fun onItemClicked(name: String)
    }
}
