package com.example.restfulapiandroid.api;

import com.example.restfulapiandroid.models.Post;

import java.util.List;

/**
 * Created by ixi.Dv on 09/11/2018.
 * Email : feedback.mrzero@gmail.com
 */
public class PostsResponse {

    private String error;
    private List<Post> posts ;

    public PostsResponse(String error, List<Post> posts) {
        this.error = error;
        this.posts = posts;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
