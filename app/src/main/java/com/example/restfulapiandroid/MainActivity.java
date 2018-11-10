package com.example.restfulapiandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.restfulapiandroid.adapters.PostAdapter;
import com.example.restfulapiandroid.api.ApiClient;
import com.example.restfulapiandroid.api.ApiService;
import com.example.restfulapiandroid.api.PostsResponse;
import com.example.restfulapiandroid.callbacks.OnPostClickListener;
import com.example.restfulapiandroid.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnPostClickListener {
    private static final String TAG = "MainActivity";
    private PostAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.posts_recycler);
        getPost();

    }


    private void getPost() {
        ApiService service = ApiClient.getService();
        service.getAllPosts().enqueue(new Callback<PostsResponse>() {
            @Override
            public void onResponse(@NonNull Call<PostsResponse> call, @NonNull Response<PostsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // fetch data from api is success
                    updateUI(response.body().getPosts());
                }
            }

            @Override
            public void onFailure(@NonNull Call<PostsResponse> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    private void updateUI(List<Post> posts) {
        adapter = new PostAdapter(posts, this); // this means onPostClick tha we have implements
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onPostClick(int postId) {
        Intent showDetails = new Intent(this, PostDetailsActivity.class);
        showDetails.putExtra(PostDetailsActivity.POST_ID, postId);
        startActivity(showDetails);


    }
}
