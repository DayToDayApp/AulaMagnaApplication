package com.daytoday.app.AulaMagnaApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    TextView title;
    TextView description;
    TextView date;
    //TextView category;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);


        title= (TextView) findViewById(R.id.card_text_title1);
        description= (TextView) findViewById(R.id.card_text_description1);
        date= (TextView) findViewById(R.id.card_text_date1);
        //category= (TextView) findViewById(R.id.card_text_category1);
        image= (ImageView) findViewById(R.id.card_image_view1);
        Bundle bundle = getIntent().getExtras();

        image.setImageResource(R.drawable.deportes);
        title.setText(bundle.getString("Title"));
        description.setText(bundle.getString("Text"));
       // category.setText(bundle.getString("Category"));
        date.setText(bundle.getString("Date"));

    }
}
