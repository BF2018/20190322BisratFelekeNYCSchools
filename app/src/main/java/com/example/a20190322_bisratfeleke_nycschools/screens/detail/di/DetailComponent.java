package com.example.a20190322_bisratfeleke_nycschools.screens.detail.di;



import com.example.a20190322_bisratfeleke_nycschools.di.AppComponent;
import com.example.a20190322_bisratfeleke_nycschools.screens.detail.mvp.DetailActivity;
import com.example.a20190322_bisratfeleke_nycschools.screens.detail.mvp.DetailContract;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = DetailModule.class, dependencies = AppComponent.class)
@DetailScope
public interface DetailComponent {
    void inject(DetailActivity detailActivity);

    @Component.Builder
    interface Builder {
        DetailComponent build();

        Builder appComponent(AppComponent appComponent);

        @BindsInstance
        Builder detailView(DetailContract.View view);
    }
}
