package com.waj.testrxjava

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_simple.*
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1

class SimpleActivity : Activity() {
    private val mObservableAction = object : Observable.OnSubscribe<String> {
        override fun call(t: Subscriber<in String>?) {
            t?.onNext("waj")
            t?.onCompleted()
        }
    }

    private val mTextSubscriber = object : Action1<String> {
        override fun call(t: String?) {
            textView.text = t
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

        //设置观察线程
        observable.observeOn(AndroidSchedulers.mainThread())

        //分发订阅信息
        observable.subscribe(mTextSubscriber)
        observable.subscribe(mToastSubscriber)
    }
}
