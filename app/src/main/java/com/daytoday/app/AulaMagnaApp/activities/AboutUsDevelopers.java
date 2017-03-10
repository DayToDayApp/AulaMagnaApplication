package com.daytoday.app.AulaMagnaApp.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.daytoday.app.AulaMagnaApp.R;

public class AboutUsDevelopers extends AppCompatActivity {


    ImageView linkedincristina;
    ImageView linkedinchema;
    ImageView linkedinraul;
    ImageView linkedindavid;
    ImageView linkedinmarcos;
    ImageView linkedindaniel;
    ImageView githubcristina;
    ImageView githubchema;
    ImageView githubraul;
    ImageView githubdavid;
    ImageView githubmarcos;
    ImageView githubdaniel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        linkedincristina = (ImageView) findViewById(R.id.linkedinbuttoncris);
        linkedinchema = (ImageView) findViewById(R.id.linkedinbuttonchema);
        linkedinraul = (ImageView) findViewById(R.id.linkedinbuttonraul);
        linkedindavid = (ImageView) findViewById(R.id.linkedinbuttondavid);
        linkedinmarcos = (ImageView) findViewById(R.id.linkedinbuttonmarcos);
        linkedindaniel = (ImageView) findViewById(R.id.linkedinbuttondani);
        githubcristina = (ImageView) findViewById(R.id.githubbutttoncris);
        githubchema = (ImageView) findViewById(R.id.githubbutttonchema);
        githubraul = (ImageView) findViewById(R.id.githubbutttonraul);
        githubdavid = (ImageView) findViewById(R.id.githubbutttondavid);
        githubmarcos = (ImageView) findViewById(R.id.githubbutttonmarcos);
        githubdaniel = (ImageView) findViewById(R.id.githubbutttondani);

        linkedincristina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.linkedincrisitina)));
                startActivity(viewIntent);

            }
        });


        linkedinchema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.linkedinchema)));
                startActivity(viewIntent);
            }
        });


        linkedinraul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.linkedinraul)));
                startActivity(viewIntent);
            }
        });


        linkedindavid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.linkedindavid)));
                startActivity(viewIntent);
            }
        });


        linkedinmarcos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.linkedinmarcos)));
                startActivity(viewIntent);
            }
        });

        linkedindaniel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.linkedindaniel)));
                startActivity(viewIntent);
            }
        });


        githubcristina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.githubcristina)));
                startActivity(viewIntent);
            }
        });


        githubchema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.githubchema)));
                startActivity(viewIntent);
            }
        });


        githubmarcos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.githubmarcos)));
                startActivity(viewIntent);
            }
        });


        githubdavid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.githubdavid)));
                startActivity(viewIntent);
            }
        });


        githubraul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.githubraul)));
                startActivity(viewIntent);
            }
        });
        githubdaniel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.githubdaniel)));
                startActivity(viewIntent);
            }
        });

    }
}



















