package com.example.a20190322_bisratfeleke_nycschools.screens.detail.di;



import com.example.a20190322_bisratfeleke_nycschools.network.WebService;
import com.example.a20190322_bisratfeleke_nycschools.screens.detail.mvp.DetailContract;
import com.example.a20190322_bisratfeleke_nycschools.screens.detail.mvp.DetailPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {
    @Provides
    @DetailScope
    public DetailContract.Presenter provideDetailPresenter(DetailContract.View view, WebService service) {
        return new DetailPresenter(view, service);
    }
}
