package com.daytoday.app.AulaMagnaApp.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daytoday.app.AulaMagnaApp.R;
import com.daytoday.app.AulaMagnaApp.manager.News;
import com.squareup.picasso.Picasso;

public class NewsActivity extends AppCompatActivity {

    TextView title;
    TextView description;
    TextView date;
    ImageView image;
    Button commentsButton;

    String urlCommets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        title= (TextView) findViewById(R.id.card_text_title1);
        description= (TextView) findViewById(R.id.card_text_description1);
        date= (TextView) findViewById(R.id.card_text_date1);
        image= (ImageView) findViewById(R.id.card_image_view1);
        commentsButton = (Button) findViewById(R.id.activity_news_commets_button);

        News news = (News) getIntent().getSerializableExtra("news");

        Picasso.with(this).load(news.getImagen()).into(image);
        title.setText(news.getTitle());
        description.setText(news.getText());

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
