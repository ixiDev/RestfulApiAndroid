package com.example.restfulapiandroid.models;

/**
 * Created by ixi.Dv on 09/11/2018.
 * Email : feedback.mrzero@gmail.com
 */
public class Post {


    private int id;
    private String title ;
    private String content;
    private String published ;
    private String author;
    private String thumbnail;

    public Post(int id, String title, String content, String published, String author, String thumbnail) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.published = published;
        this.author = author;
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
