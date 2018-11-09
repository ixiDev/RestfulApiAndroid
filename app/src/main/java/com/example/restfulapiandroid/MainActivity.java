package com.example.restfulapiandroid;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.restfulapiandroid.api.ApiClient;
import com.example.restfulapiandroid.api.ApiService;
import com.example.restfulapiandroid.api.PostsResponse;
import com.example.restfulapiandroid.models.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPost();

    }

    /**
     * test method
     */
    private void getPost() {
        ApiService service = ApiClient.getService();

        service.getAllPosts().enqueue(new Callback<PostsResponse>() {
            @Override
            public void onResponse(@NonNull Call<PostsResponse> call, @NonNull Response<PostsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // fetch data from api is success
                    for (Post post : response.body().getPosts()) {
                        Log.i(TAG, "onResponse: " + post);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<PostsResponse> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }


}
