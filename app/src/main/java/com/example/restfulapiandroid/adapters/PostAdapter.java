package com.example.restfulapiandroid.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.restfulapiandroid.R;
import com.example.restfulapiandroid.callbacks.OnPostClickListener;
import com.example.restfulapiandroid.models.Post;

import java.util.List;

/**
 * Created by ixi.Dv on 10/11/2018.
 * Email : feedback.mrzero@gmail.com
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    private LayoutInflater inflater;
    private List<Post> posts;
    private OnPostClickListener onPostClickListener;

    public PostAdapter(List<Post> posts, OnPostClickListener onPostClickListener) {
        this.posts = posts;
        this.onPostClickListener = onPostClickListener;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        if (inflater == null)
            inflater = LayoutInflater.from(parent.getContext());
        return new PostHolder(inflater.inflate(R.layout.post_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        final Post item = posts.get(position);
        holder.title.setText(item.getTitle());
        holder.author.setText(item.getAuthor());
        holder.date.setText(item.getPublished());
        // load thumbnail
        Glide.with(holder.thumbnail)
                .load(item.getThumbnail())
                .into(holder.thumbnail);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (onPostClickListener!=null)
                   onPostClickListener.onPostClick(item.getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        if (posts == null) // no posts found
            return 0;

        return posts.size();
    }

    class PostHolder extends RecyclerView.ViewHolder {
        TextView title, date, author;
        ImageView thumbnail;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.post_title);
            this.date = itemView.findViewById(R.id.post_date);
            this.author = itemView.findViewById(R.id.post_author);
            this.thumbnail = itemView.findViewById(R.id.post_thumbnail);

        }
    }
}
