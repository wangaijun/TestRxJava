package com.waj.testrxjava.service;

import com.waj.testrxjava.adapter.UserListAdapter;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

interface GitHubService {
    String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}")
    Observable<UserListAdapter.GitHubUser> getUserData(@Path("user") String user);
}