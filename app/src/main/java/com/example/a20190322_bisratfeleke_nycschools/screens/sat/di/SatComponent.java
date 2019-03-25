package com.example.a20190322_bisratfeleke_nycschools.screens.sat.di;



import com.example.a20190322_bisratfeleke_nycschools.di.AppComponent;
import com.example.a20190322_bisratfeleke_nycschools.screens.sat.mvp.SatActivity;
import com.example.a20190322_bisratfeleke_nycschools.screens.sat.mvp.SatContract;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = SatModule.class, dependencies = AppComponent.class)
@SatScope
public interface SatComponent {
    void inject(SatActivity satActivity);

    @Component.Builder
    interface Builder {
        SatComponent build();

        Builder appComponent(AppComponent appComponent);

        @BindsInstance
        Builder detailView(SatContract.View view);
    }
}
