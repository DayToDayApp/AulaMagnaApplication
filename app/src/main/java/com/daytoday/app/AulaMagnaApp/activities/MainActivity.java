package com.daytoday.app.AulaMagnaApp.activities;

import android.content.Intent;
import android.os.Bundle;
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
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.daytoday.app.AulaMagnaApp.R;
import com.daytoday.app.AulaMagnaApp.adapter.RVAdapter;
import com.daytoday.app.AulaMagnaApp.manager.News;
import com.daytoday.app.AulaMagnaApp.utils.Constants;
import com.daytoday.app.AulaMagnaApp.utils.MyRss2Parser;
import com.pkmmte.pkrss.Article;
import com.pkmmte.pkrss.Callback;
import com.pkmmte.pkrss.PkRSS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import io.realm.RealmResults;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, Callback {

    private List<News> noticias = new ArrayList<>();
    private RecyclerView rv;

    private int numberOfCard;
    private String currentUrl = "https://demo6130055.mockable.io/AulaMagnafeedApp";// "http://www.aulamagna.com.es/feed";

    Button loadNewsButton;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadNewsButton = (Button) findViewById(R.id.content_main_load_news_button);
        progressBar= (ProgressBar) findViewById(R.id.progressbar);

        Toolbar toolbar = getToolbar();
        drawer(toolbar);
        navbar();
        initializeAdapter();
        paintToRealm();

        loadNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            initializeAdapter();
            PkRSS.with(view.getContext()).load(currentUrl).callback(MainActivity.this).parser(new MyRss2Parser()).async();
            numberOfCard = numberOfCard + 10;

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        PkRSS.with(this).load(currentUrl).callback(this).parser(new MyRss2Parser()).async();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private Toolbar getToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        return toolbar;
    }

    private void navbar() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void drawer(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void initializeAdapter() {
        rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        rv.setLayoutManager(llm);

        RVAdapter adapter = new RVAdapter(this, noticias);
        adapter.notifyDataSetChanged();
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
        getMenuInflater().inflate(R.menu.lateral_menu, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        loadNewCategory(id);
        closeNavigationDrawer();
        return true;
    }

    private void loadNewCategory(int id) {
        if(id == R.id.nav_portada) {
            currentUrl = "http://www.aulamagna.com.es/feed/";
        } else if (id == R.id.nav_hemeroteca) {
            Intent intent = new Intent(MainActivity.this, HemerotecaActivity.class);
            startActivity(intent);
        }  else if(id == R.id.nav_aboutus){
            Intent intent = new Intent (MainActivity.this, AboutUsDevelopers.class);
            startActivity(intent);
        }
        else {
            HashMap<Integer, String> categoryMap = new HashMap<Integer, String>() {{
                put(R.id.nav_andalucia_almeria,"andalucia/almeria");
                put(R.id.nav_andalucia_cordoba,"andalucia/cordoba");
                put(R.id.nav_andalucia_cadiz,"andalucia/cadiz");
                put(R.id.nav_andalucia_malaga,"andalucia/malaga");
                put(R.id.nav_andalucia_sevilla,"andalucia/sevilla");
                put(R.id.nav_andalucia_huelva,"andalucia/huelva");
                put(R.id.nav_andalucia_jaen,"andalucia/jaen");
                put(R.id.nav_andalucia_granada,"andalucia/granada");

                put(R.id.nav_madrid,"madrid");
                put(R.id.nav_deportes,"deportes");
                put(R.id.nav_emprendimiento,"emprendimiento");
                put(R.id.nav_infobecas,"infobecas");

                put(R.id.nav_formacion_financiera,"financiera");
                put(R.id.nav_formacion_posgrados,"posgrados");

                put(R.id.nav_opinion_editorial, "/opinion/editorial");
                put(R.id.nav_opinion_paraninfo, "/opinion/paraninfo2");
                put(R.id.nav_opinion_tribuna, "/opinion/tribuna");
            }};
            String category = categoryMap.get(id);

            currentUrl = String.format("http://www.aulamagna.com.es/category/%s/feed/", category);
        }


        PkRSS.with(this).load(currentUrl).callback(this).async();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveToRealm();
    }
    private void saveToRealm() {
        io.realm.Realm realm= io.realm.Realm.getDefaultInstance();
        realm.beginTransaction();

        for (News newnoticia:noticias) {
            realm.copyToRealmOrUpdate(newnoticia);
        }
        realm.commitTransaction();
    }

    private  void paintToRealm(){
        io.realm.Realm realm = io.realm.Realm.getDefaultInstance();
        RealmResults<News> realmResults = realm.where(News.class).findAll();

        for (News loadnews:realmResults) {
            noticias.add(loadnews);
        }
        initializeAdapter();
    }

    private void closeNavigationDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    public static String formatDateAsDayMonthYearHourMin(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dateStr = simpleDateFormat.format(date);

        return dateStr;
    }


    @Override
    public void onPreload() {
        loadNewsButton.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoaded(List<Article> newArticles) {
        loadNewsButton.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        noticias = new ArrayList<>();

        for (int i = 0; i < numberOfCard+Constants.NEW_ARTICLES; i++) {
            // parse the id for use in Realm
            int id= newArticles.get(i).getId();
            String  imagen="" +newArticles.get(i).getImage();
            String title = newArticles.get(i).getTitle();
            String text = newArticles.get(i).getDescription();
            String urlCommets = newArticles.get(i).getSource().toString() + "#respond";
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", Locale.US);
            dateFormat.setTimeZone(Calendar.getInstance().getTimeZone());
            String urlSource="" +newArticles.get(i).getSource();
            Date pkrssparseddate = new Date(newArticles.get(i).getDate() * 1000);
            String dateStr = formatDateAsDayMonthYearHourMin(pkrssparseddate);
            List<String> listCategory = newArticles.get(i).getTags();
            noticias.add(new News(title,text,dateStr,id,imagen,urlCommets,urlSource));
        }
        initializeAdapter();
    }

    @Override
    public void onLoadFailed() {
        //When we don't have conection show a toastBar
        Toast.makeText(getApplicationContext(), "Error: no es posible conectar", Toast.LENGTH_LONG).show();

    }
}