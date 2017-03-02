package com.daytoday.app.AulaMagnaApp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.daytoday.app.AulaMagnaApp.R;
import com.daytoday.app.AulaMagnaApp.activities.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {


    private static final long SPLASH_SCREEN_DELAY = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                Intent mainIntent = new Intent().setClass(
                        SplashActivity.this, MainActivity.class);

                startActivity(mainIntent);


                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);


    }
}
