package com.waj.testrxjava

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gotoModule(v: View) {
        startActivity(Intent(this,when(v){
            btnSimple->SimpleActivity::class.java
            btnMore->MoreActivity::class.java
            btnLambda->LambdaActivity::class.java
            btnNetWork->RetrofitActivity::class.java
            else->SimpleActivity::class.java
        }))
    }
}
