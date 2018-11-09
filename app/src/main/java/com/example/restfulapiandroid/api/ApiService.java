package com.example.restfulapiandroid.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ixi.Dv on 09/11/2018.
 * Email : feedback.mrzero@gmail.com
 */
public interface ApiService {
    /**
     * get All post
     */
    @GET("/resfulapiandroid/v1/posts")
    Call<PostsResponse> getAllPosts();

    /**
     * getPost by id
     */

    @GET("/resfulapiandroid/v1/posts/{id}")
    Call<PostsResponse> getPost(
            @Path("id") int postId);

}
