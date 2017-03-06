package com.daytoday.app.AulaMagnaApp.manager;

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

import static android.R.attr.id;

public class News extends RealmObject implements Serializable {

    @PrimaryKey private int id;
     private String title;
    private Date date;
    @Ignore private List<String> listCategory;
    private String text;
    //private RequestCreator imagen;
    public News(){
        //empty contructor for realm-request
    }

    public News(String title, String text, Date date, int id) {
        this.title=title;
        this.text=text;
        this.date=date;
        this.id=id;

    }

    public News(String title, String text, Date date) {
       this.text=text;
        this.title = title;
        this.date = date;
        //this.category= category;

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

/*    public RequestCreator   getImagen() {
        return imagen;
    }

    public void setImagen(RequestCreator   imagen) {
        this.imagen = imagen;
    }*/
}


