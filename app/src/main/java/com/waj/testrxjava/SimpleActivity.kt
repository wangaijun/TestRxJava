package com.waj.testrxjava

import android.app.Activity
import android.os.Bundle

class SimpleActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)
    }
}
