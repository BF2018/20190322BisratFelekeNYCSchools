package com.example.a20190322_bisratfeleke_nycschools.screens.sat.di;



import com.example.a20190322_bisratfeleke_nycschools.network.WebService;
import com.example.a20190322_bisratfeleke_nycschools.screens.sat.mvp.SatContract;
import com.example.a20190322_bisratfeleke_nycschools.screens.sat.mvp.SatPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class SatModule {
    @Provides
    @SatScope
    public SatContract.Presenter provideDetailPresenter(SatContract.View view, WebService service) {
        return new SatPresenter(view, service);
    }
}
