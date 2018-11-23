package com.waj.testrxjava.activity

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.waj.testrxjava.R
import kotlinx.android.synthetic.main.activity_simple.*
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers

class SimpleActivity : Activity() {
    private val mObservableAction = object : Observable.OnSubscribe<String> {
        override fun call(t: Subscriber<in String>?) {
            t?.onNext("waj")
            t?.onCompleted()
        }
    }

    private val mTextSubscriber = object : Subscriber<String>() {
        override fun onNext(t: String?) {
            textView.text = t
        }

        override fun onCompleted() {
            textView.append("onCompleted")
        }

        override fun onError(e: Throwable?) {
            textView.text = "$e"
        }
    }

    private val mToastSubscriber = object : Action1<String> {
        override fun call(t: String?) {
            t?.let {
                Toast.makeText(this@SimpleActivity,it,Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        //注册观察活动
        val observable = Observable.create(mObservableAction)
            //设置执行线程、观察线程
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

        //分发订阅信息
        observable.subscribe(mTextSubscriber)
        observable.subscribe(mToastSubscriber)
    }
}
