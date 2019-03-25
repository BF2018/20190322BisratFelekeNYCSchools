package com.example.a20190322_bisratfeleke_nycschools.screens.school.di;



import com.example.a20190322_bisratfeleke_nycschools.di.AppComponent;
import com.example.a20190322_bisratfeleke_nycschools.screens.school.mvp.SchoolActivity;
import com.example.a20190322_bisratfeleke_nycschools.screens.school.mvp.SchoolContract;

import dagger.BindsInstance;
import dagger.Component;


@Component(modules = SchoolModule.class, dependencies = AppComponent.class)
@SchoolScope
public interface SchoolComponent {
    void inject(SchoolActivity schoolActivity);

    @Component.Builder
    interface Builder {
        SchoolComponent build();

        Builder appComponent(AppComponent appComponent);

        @BindsInstance
        Builder mainView(SchoolContract.View view);
    }

}
