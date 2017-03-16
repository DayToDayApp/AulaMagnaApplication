package com.daytoday.app.AulaMagnaApp.manager;

import java.util.Date;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

public class News extends RealmObject {

    @PrimaryKey private int id;
    private String title;
    private String date;
    @Ignore private List<String> listCategory;
    private String text;
    private String imagen;
    private String urlComments;
    private String urlSource;
    private String category;

    public News(){
    }

    public News(String title, String text, String date, int id, String img, String urlCommets,String  urlSource, String category){
        this.title = title;
        this.text = text;
        this.date = date;
        this.id = id;
        this.imagen = img;
        this.urlComments = urlCommets;
        this.urlSource = urlSource;
        this.category = category;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String  getImagen() {
        return imagen;
    }

    public void setImagen(String  imagen) {
        this.imagen = imagen;
    }

    public String getUrlComments() {
        return urlComments;
    }

    public void setUrlComments(String urlComments) {
        this.urlComments = urlComments;
    }

    public String getUrlSource() {
        return urlSource;
    }

    public void setUrlSource(String urlSource) {
        this.urlSource = urlSource;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}


