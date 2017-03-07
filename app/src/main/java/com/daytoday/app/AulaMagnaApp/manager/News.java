package com.daytoday.app.AulaMagnaApp.manager;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

import static android.R.attr.category;
import static android.R.attr.id;
import static android.R.attr.thickness;

public class News extends RealmObject implements Serializable {

    @PrimaryKey private int id;
     private String title;
    private Date date;
    @Ignore private List<String> listCategory;
    private String text;
    private String imagen;
    private String urlComments;

    public News(){
        //empty contructor for realm-request
    }
    public News(String title, String text, Date date, int id, String img, String urlCommets){
        this.title=title;
        this.text=text;
        this.date=date;
        this.id=id;
        this.imagen=img;
        this.urlComments=urlCommets;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}


