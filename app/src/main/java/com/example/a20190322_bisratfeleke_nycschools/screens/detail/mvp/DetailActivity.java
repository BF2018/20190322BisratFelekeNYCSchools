package com.example.a20190322_bisratfeleke_nycschools.screens.detail.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a20190322_bisratfeleke_nycschools.R;
import com.example.a20190322_bisratfeleke_nycschools.app.App;
import com.example.a20190322_bisratfeleke_nycschools.screens.detail.di.DaggerDetailComponent;


import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity implements DetailContract.View {

    @Inject
    DetailPresenter mDetailPresenter;

    TextView mSchoolName, mSatReading, mSatMaths, mSatWriting;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_view);
        DaggerDetailComponent.builder()
                .appComponent(((App) getApplication()).getAppComponent())
                .detailView(this)
                .build()
                .inject(this);

        mSchoolName = findViewById(R.id.tv_school_name);
        mSatReading = findViewById(R.id.tv_reading);
        mSatMaths = findViewById(R.id.tv_maths);
        mSatWriting =findViewById(R.id.tv_writing);

        Intent intent = getIntent();
        String schoolName = intent.getStringExtra("school_name");

        mDetailPresenter.getDetailData(schoolName);

    }


    @Override
    public void onFetchDetail(String maths, String reading, String writing,String schoolName) {
        mSchoolName.setText(schoolName);
        mSatReading.setText(reading);
        mSatMaths.setText(maths);
        mSatWriting.setText(writing);
    }

    @Override
    public void onError(String error) {
        Log.v("Detail_Error", error);
        Toast.makeText(getApplicationContext(), "Problem with loading data", Toast.LENGTH_LONG).show();
    }
}
