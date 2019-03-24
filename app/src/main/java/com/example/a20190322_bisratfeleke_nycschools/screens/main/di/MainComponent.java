package com.example.a20190322_bisratfeleke_nycschools.screens.main.di;



import com.example.a20190322_bisratfeleke_nycschools.di.AppComponent;
import com.example.a20190322_bisratfeleke_nycschools.screens.main.mvp.MainActivity;
import com.example.a20190322_bisratfeleke_nycschools.screens.main.mvp.MainContract;

import dagger.BindsInstance;
import dagger.Component;


@Component(modules = MainModule.class, dependencies = AppComponent.class)
@MainScope
public interface MainComponent {
    void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder {
        MainComponent build();

        Builder appComponent(AppComponent appComponent);

        @BindsInstance
        Builder mainView(MainContract.View view);
    }

}
