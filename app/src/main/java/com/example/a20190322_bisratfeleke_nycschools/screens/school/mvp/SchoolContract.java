package com.example.a20190322_bisratfeleke_nycschools.screens.school.mvp;

import android.content.Context;

import com.example.a20190322_bisratfeleke_nycschools.model.SchoolResponse;

import java.util.List;

public interface SchoolContract {

    interface View {

        void onDataSuccess(List<SchoolResponse> schoolList);


        void onDataFailure(String message);

    }

    interface Presenter {
        void getData(Context context);
    }
}
