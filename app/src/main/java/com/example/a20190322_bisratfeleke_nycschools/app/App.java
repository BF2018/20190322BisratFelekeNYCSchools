package com.example.a20190322_bisratfeleke_nycschools.app;

import android.app.Application;

import com.example.a20190322_bisratfeleke_nycschools.di.AppComponent;
import com.example.a20190322_bisratfeleke_nycschools.di.DaggerAppComponent;


public class App extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
