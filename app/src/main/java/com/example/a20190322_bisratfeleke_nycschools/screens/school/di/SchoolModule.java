package com.example.a20190322_bisratfeleke_nycschools.screens.school.di;


import com.example.a20190322_bisratfeleke_nycschools.network.WebService;
import com.example.a20190322_bisratfeleke_nycschools.screens.school.mvp.SchoolContract;
import com.example.a20190322_bisratfeleke_nycschools.screens.school.mvp.SchoolPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SchoolModule {
    @Provides
    @SchoolScope
    public SchoolContract.Presenter provideMainPresenter(SchoolContract.View mainView, WebService webServices) {
        return new SchoolPresenter(mainView, webServices);
    }
}
