package com.waj.testrxjava.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.waj.testrxjava.R

class NetWorkDetailActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_net_work_detail)
    }

    companion object {
        fun from(activity: Activity, name: String): Intent {
            val i = Intent(activity, NetWorkDetailActivity::class.java)
            i.putExtra("name",name)
            return i
        }
    }
}
