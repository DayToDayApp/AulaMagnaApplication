package com.daytoday.app.AulaMagnaApp.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daytoday.app.AulaMagnaApp.R;
import com.daytoday.app.AulaMagnaApp.manager.News;
import com.squareup.picasso.Picasso;

import io.realm.Realm;
import io.realm.RealmQuery;

public class NewsActivity extends AppCompatActivity {

    TextView title;
    TextView description;
    TextView date;
    ImageView image;
    Button commentsButton;
    TextView continueRead;

    String urlCommets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        title= (TextView) findViewById(R.id.card_text_title1);
        description= (TextView) findViewById(R.id.card_text_description1);
        date= (TextView) findViewById(R.id.card_text_date1);
        image= (ImageView) findViewById(R.id.card_image_view1);
        continueRead = (TextView) findViewById(R.id.text_continue_read);
        commentsButton = (Button) findViewById(R.id.activity_news_commets_button);

        int id =  getIntent().getIntExtra("news_id", -1);

        RealmQuery<News> query = Realm.getDefaultInstance().where(News.class).equalTo("id", id);

        News news = null;

        if (query.count() == 1) {
            news = query.findFirst();
        }

        Picasso.with(this).load(news.getImagen()).into(image);
        title.setText(news.getTitle());
        description.setText(news.getText());

        final String urlSorce = news.getUrlSorce();
        continueRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent("android.intent.action.VIEW",Uri.parse(urlSorce));
                startActivity(intent);
            }
        });

        urlCommets = news.getUrlComments();

        commentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(urlCommets));
                startActivity(viewIntent);
            }
        });


    }
}
