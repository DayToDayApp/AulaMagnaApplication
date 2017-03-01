package com.daytoday.app.AulaMagnaApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    ImageView imagen;
    TextView textView1;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        imagen= (ImageView) findViewById(R.id.image_view);
        textView1= (TextView) findViewById(R.id.text_view);
        textView2= (TextView) findViewById(R.id.text_view2);
        Bundle bundle = getIntent().getExtras();

        textView1.setText(bundle.getString("Title"));
        textView2.setText(bundle.getString("Text"));
    }
}
