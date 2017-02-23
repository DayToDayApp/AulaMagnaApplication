package com.example.dancd.aulamagnaapp.manager;

class Noticia {
    String title;
    String date;
    String category;
    String text;
    int photoId;

    Noticia(String title, String date,String category, int photoId, String text) {
        this.title = title;
        this.date = date;
        this.category= category;
        this.text=text;
        this.photoId = photoId;
    }
}