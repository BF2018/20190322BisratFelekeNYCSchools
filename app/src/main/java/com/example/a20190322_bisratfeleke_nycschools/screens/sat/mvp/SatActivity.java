package com.example.a20190322_bisratfeleke_nycschools.screens.sat.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a20190322_bisratfeleke_nycschools.R;
import com.example.a20190322_bisratfeleke_nycschools.app.App;
import com.example.a20190322_bisratfeleke_nycschools.screens.sat.di.DaggerSatComponent;

import javax.inject.Inject;

public class SatActivity extends AppCompatActivity implements SatContract.View {

    @Inject
    SatPresenter mSatPresenter;

    TextView mSchoolName, mSatReading, mSatMaths, mSatWriting;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sat_view);
        DaggerSatComponent.builder()
                .appComponent(((App) getApplication()).getAppComponent())
                .detailView(this)
                .build()
                .inject(this);

        mSchoolName = findViewById(R.id.tv_school_name);
        mSatReading = findViewById(R.id.tv_reading);
        mSatMaths = findViewById(R.id.tv_maths);
        mSatWriting =findViewById(R.id.tv_writing);

        Intent intent = getIntent();
        String schoolName = intent.getStringExtra("dbn");

        mSatPresenter.getDetailData(schoolName);

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
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
    }
}
