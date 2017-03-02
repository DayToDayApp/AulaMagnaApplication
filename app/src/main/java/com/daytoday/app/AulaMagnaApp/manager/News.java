package com.daytoday.app.AulaMagnaApp.manager;

import android.net.Uri;

import java.text.SimpleDateFormat;
import java.util.Date;

public class News {
    private String title;
    private Date date;
    private String category;
    private String text;

    public News(String title, String text, Date date) {
       this.text=text;
        this.title = title;
        this.date = date;
        //this.category= category;

    }
    private Uri photoId;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public News(Uri photo, String title, Date  date, String category, String text) {
        this.title = title;
        this.date = date;
        this.category= category;
        this.text=text;
        this.photoId = photo;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

   /* public Uri getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Uri photoId) {
        this.photoId = photoId;
    }
}*/