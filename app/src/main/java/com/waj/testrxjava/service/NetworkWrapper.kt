package com.waj.testrxjava.service

import com.waj.testrxjava.adapter.UserListAdapter
import rx.Observable
import rx.android.schedulers.AndroidSchedulers

object NetworkWrapper {
    private val mFamousUsers = arrayOf("one","two","three")
    fun getUsersInfo(adapter: UserListAdapter) {
        val gitHubService = ServiceFactory.createServiceFrom(
            GitHubService::class.java,
            GitHubService.ENDPOINt
        )
        Observable.from(mFamousUsers)
            .flatMap { name->gitHubService.getUserData(name) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(adapter::addUser)
    }
}