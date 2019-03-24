package com.example.a20190322_bisratfeleke_nycschools.screens.main.di;


import com.example.a20190322_bisratfeleke_nycschools.network.WebService;
import com.example.a20190322_bisratfeleke_nycschools.screens.main.mvp.MainContract;
import com.example.a20190322_bisratfeleke_nycschools.screens.main.mvp.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    @MainScope
    public MainContract.Presenter provideMainPresenter(MainContract.View mainView, WebService webServices) {
        return new MainPresenter(mainView, webServices);
    }
}
