package com.daytoday.app.AulaMagnaApp.manager;

import android.net.Uri;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class News {
    private String title;
    private Date date;
    private List<String> listCategory;
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

    public List<String> getListCategory() {
        return listCategory;
    }

    public void setListCategory(List<String> listCategory) {
        this.listCategory = listCategory;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public News(String title, Date date, List<String> listCategory, String text, Uri photoId) {
        this.title = title;
        this.date = date;
        this.listCategory = listCategory;
        this.text = text;
        this.photoId = photoId;
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