package com.waj.testrxjava

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_lambda.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class LambdaActivity : Activity() {
    private val mManyWordList = arrayListOf("hello","I","am","your","friend","spike")

    private fun toast(t: String?) {
        t?.let { Toast.makeText(this,it, Toast.LENGTH_LONG).show() }
    }


    private fun mergeString(t: String?, t2: String) = String.format("%s %s", t, t2)

    private fun sayMyName() :String{
        return "Hello,I am you friend,Spike!"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lambda)

        val obShow = Observable.just(sayMyName())
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        obShow.map(String::toUpperCase).subscribe(tv::setText)

        val obMap = Observable.from(mManyWordList).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        obMap.map(String::toUpperCase).subscribe(this::toast)

        val ob = Observable.just(mManyWordList).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        ob.flatMap { strings -> Observable.from(strings) }
            .reduce(this::mergeString)
            .subscribe(this::toast)//
    }
}
