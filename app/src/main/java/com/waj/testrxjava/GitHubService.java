package com.waj.testrxjava;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

interface GitHubService {
    String ENDPOINt = "https://api.github.com";
    @GET("/users/{user}")
    Observable<UserListAdapter.GitHubUser> getUserData(@Path("user") String user);
}