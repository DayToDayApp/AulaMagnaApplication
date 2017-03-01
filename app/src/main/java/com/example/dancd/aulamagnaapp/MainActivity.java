package com.example.dancd.AulaMagnaApp;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.dancd.AulaMagnaApp.manager.News;
import com.pkmmte.pkrss.Article;
import com.pkmmte.pkrss.Callback;
import com.pkmmte.pkrss.PkRSS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, Callback {

    private List<News> noticias = new ArrayList<>();
    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);





        initializeAdapter();
        loadNewCategory(R.id.nav_almeria);
    }

    private void initializeAdapter() {
        Log.d("","init adapter");

        rv = (RecyclerView) findViewById(R.id.rv);
        RVAdapter adapter = new RVAdapter(noticias);
        rv.swapAdapter(adapter, true);
        adapter.notifyDataSetChanged();
        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        rv.setLayoutManager(llm);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lateral_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        loadNewCategory(id);

        closeNavigationDrawer();

        return true;
    }

    private void loadNewCategory(int id) {
        HashMap<Integer, String> categoryMap = new HashMap<Integer, String>() {{
            put(R.id.nav_almeria,"andalucia/almeria");
            put(R.id.nav_cordoba,"andalucia/cordoba");
            put(R.id.nav_cadiz,"andalucia/cadiz");
            put(R.id.nav_malaga,"andalucia/malaga");
            put(R.id.nav_sevilla,"andalucia/sevilla");
            put(R.id.nav_huelva,"andalucia/huelva");
            put(R.id.nav_jaen,"andalucia/jaen");
            put(R.id.nav_granada,"andalucia/granada");
            put(R.id.nav_madrid,"madrid");
            put(R.id.nav_deportes,"deportes");
            put(R.id.nav_emprendimiento,"emprendimiento");
            put(R.id.nav_infobecas,"infobecas");
            put(R.id.nav_formacion_financiera,"formacion_financiera");
            put(R.id.nav_formacion_posgrados,"formacion_posgrados");


        }};

        String category = categoryMap.get(id);

        String url = String.format("http://www.aulamagna.com.es/category/%s/feed/", category);
        PkRSS.with(this).load(url).callback(this).async();
    }

    @Override
    public void onPreload() {
        Log.d("On preload", "On preload");
    }


    @Override
    public void onLoaded(List<Article> newArticles) {


        noticias = new ArrayList<>();
        for (int i = 0; i < newArticles.size(); i++) {
            Uri photo=newArticles.get(i).getImage();
            String title = newArticles.get(i).getTitle();
            String date = "" + newArticles.get(i).getDate();
            String category = ""+ newArticles.get(i).getContent();
            String text = newArticles.get(i).getDescription();

            noticias.add(new News(title, date, category));

        }
        initializeAdapter();
    }

    @Override
    public void onLoadFailed() {
        Log.d("on load failed", "on load failed");
    }

    private void closeNavigationDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

}

