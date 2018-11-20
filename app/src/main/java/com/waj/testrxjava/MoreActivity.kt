package com.waj.testrxjava

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_more.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.functions.Func1
import rx.functions.Func2
import rx.schedulers.Schedulers

class MoreActivity : Activity() {

    val mManyWords = arrayOf("hello","I","am","your","friend","spike")
    val mManyWordList = arrayListOf("hello","I","am","your","friend","spike")

    val mTextViewAction = object: Action1<String>{
        override fun call(t: String?) {
            tv.text = t
        }
    }

    val mToastAction = object : Action1<String>{
        override fun call(t: String?) {
            toast(t)
        }
    }

    private fun toast(t: String?) {
        t?.let { Toast.makeText(this,it,Toast.LENGTH_LONG).show() }
    }

    val mOneWordFunc = object : Func1<List<String>,Observable<String>>{
        override fun call(strings: List<String>?): Observable<String> {
            return Observable.from(strings)
        }
    }

    val mUpperLetterFunc = object : Func1<String,String>{
        override fun call(t: String?): String {
            return t?.toUpperCase()?:""
        }
    }

    val mMergeStringFunc = object : Func2<String, String, String> {
        override fun call(t: String?,t2:String): String {
             return String.format("%s %s",t,t2)
        }
    }

    fun sayMyName() :String{
        return "Hello,I am you friend,Spike!"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)

        val obShow = Observable.just(sayMyName())
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        obShow.map(mUpperLetterFunc).subscribe(mTextViewAction)

        val obMap = Observable.from(mManyWordList).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        obMap.map(mUpperLetterFunc).subscribe(mToastAction)

        val ob = Observable.just(mManyWordList).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        ob.flatMap(mOneWordFunc)
            .reduce(mMergeStringFunc)
            .subscribe(mToastAction)//

    }
}
