package com.example.a20190322_bisratfeleke_nycschools.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    @Singleton
    public Context provideApplicationContext(Application application) {
        return application;
    }
}
