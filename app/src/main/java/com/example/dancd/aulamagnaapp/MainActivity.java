package com.example.dancd.aulamagnaapp;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.dancd.aulamagnaapp.manager.Noticia;

import java.util.ArrayList;
import java.util.List;

import static com.example.dancd.aulamagnaapp.R.id.toolbar;

public class MainActivity extends AppCompatActivity {

    private List<Noticia> noticias;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

new Thread(new Runnable() {
    @Override
    public void run() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                SystemClock.sleep(500);
            }
        });
    }
}).start();


        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                initializeData();
                initializeAdapter();
                SystemClock.sleep(500);
            }
        }).start();



    }

    private void initializeData() {
        noticias = new ArrayList<>();
        noticias.add(new Noticia("CRISTINA", "24.02.2017", "Cultura", R.drawable.logo_aulamagna, "GRAN APP CREADA POR NOSOTROS DAYTODAY"));
        noticias.add(new Noticia("CHEMA", "24.02.2017", " Cultura", R.drawable.logo_aulamagna, "GRAN APP CREADA POR NOSOTROS DAYTODAY"));
        noticias.add(new Noticia("MARCOS", "24.02.2017", "Cultura", R.drawable.logo_aulamagna, "GRAN APP CREADA POR NOSOTROS DAYTODAY"));
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(noticias);
        rv.setAdapter(adapter);
    }
}

