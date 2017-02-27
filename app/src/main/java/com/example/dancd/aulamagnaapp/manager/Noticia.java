package com.example.dancd.aulamagnaapp.manager;

public class Noticia {
    private String title;
    private String date;
    private String category;
    private String text;
    //private int photoId;


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

    public Noticia(String title, String date, String category, String text) {
        this.title = title;
        this.date = date;
        this.category= category;
        this.text=text;
        //this.photoId = photoId;
    }
}