package com.waj.testrxjava.service

import com.waj.testrxjava.adapter.UserListAdapter
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

object NetworkWrapper {
    private val mFamousUsers = arrayOf("wangaijun","SpikeKing","JakeWharton","rock3r","Takhion","dextorer","Mariuxtheone")
    fun getUsersInfo(adapter: UserListAdapter) {
        val gitHubService = ServiceFactory.createServiceFrom(
            GitHubService::class.java,
            GitHubService.ENDPOINT
        )
        Observable.from(mFamousUsers)
            .flatMap { name->gitHubService.getUserData(name) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(adapter::addUser)
    }
}