package com.example.a20190322_bisratfeleke_nycschools.di;

import android.app.Application;


import com.example.a20190322_bisratfeleke_nycschools.network.WebService;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    WebService webService();

    @Component.Builder
    interface Builder {

        AppComponent build();

        @BindsInstance
        Builder application(Application application);
    }
}
