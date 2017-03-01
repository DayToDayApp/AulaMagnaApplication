package com.daytoday.app.AulaMagnaApp.manager;

import android.net.Uri;

public class News {
    private String title;
    private String date;
    private String category;
    private String text;

    public News(String title, String date, String category) {
        //this.photoId=photo;
        this.title = title;
        this.date = date;
        this.category= category;

    }
    private Uri photoId;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }

    public News(Uri photo, String title, String date, String category, String text) {
        this.title = title;
        this.date = date;
        this.category= category;
        this.text=text;
        this.photoId = photo;
    }
}

   /* public Uri getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Uri photoId) {
        this.photoId = photoId;
    }
}*/