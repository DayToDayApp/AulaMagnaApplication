package com.example.dancd.aulamagnaapp;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dancd.aulamagnaapp.manager.Noticia;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private List<Noticia> noticias;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SystemClock.sleep(500);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();




    }

    private void initializeData() {
        noticias = new ArrayList<>();
        noticias.add(new Noticia("CRISTINA", "24.02.2017", "Cultura", R.drawable.logo_aulamagna_peque, "GRAN APP CREADA POR NOSOTROS DAYTODAY"));
        noticias.add(new Noticia("CHEMA", "24.02.2017", " Cultura", R.drawable.logo_aulamagna_peque, "GRAN APP CREADA POR NOSOTROS DAYTODAY"));
        noticias.add(new Noticia("MARCOS", "24.02.2017", "Cultura", R.drawable.logo_aulamagna_peque, "GRAN APP CREADA POR NOSOTROS DAYTODAY"));
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(noticias);
        rv.setAdapter(adapter);
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lateral_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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

        if (id == R.id.nav_almeria) {
            // Handle the camera action
        } else if (id == R.id.nav_cadiz) {

        } else if (id == R.id.nav_cordoba) {

        } else if (id == R.id.nav_granada) {

        } else if (id == R.id.nav_huelva) {

        } else if (id == R.id.nav_jaen) {

        } else if (id == R.id.nav_malaga) {

        } else if (id == R.id.nav_sevilla) {

        } else if (id == R.id.nav_madrid) {

        } else if (id == R.id.nav_deportes) {

        } else if (id == R.id.nav_emprendimiento) {

        } else if (id == R.id.nav_infobecas) {

        } else if (id == R.id.nav_formacion_financiera) {

        } else if (id == R.id.nav_formacion_posgrados) {

        } else if (id == R.id.nav_formacion_posgrados) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

