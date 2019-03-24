package com.example.a20190322_bisratfeleke_nycschools.screens.main.mvp;

import android.content.Context;

import com.example.a20190322_bisratfeleke_nycschools.model.school.SchoolResponse;


import java.util.List;

public interface MainContract {

    interface View {

        void onDataSuccess(List<SchoolResponse> schoolList);


        void onDataFailure(String message);

    }

    interface Presenter {
        void getData(Context context);
    }
}
