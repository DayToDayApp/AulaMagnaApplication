package com.daytoday.app.AulaMagnaApp;

import android.app.Application;

import io.realm.Realm;

public class AulaMagnaAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
    }
}
