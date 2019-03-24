package com.example.a20190322_bisratfeleke_nycschools.screens.main.mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.a20190322_bisratfeleke_nycschools.R;
import com.example.a20190322_bisratfeleke_nycschools.app.App;
import com.example.a20190322_bisratfeleke_nycschools.model.sat.SatResponse;
import com.example.a20190322_bisratfeleke_nycschools.model.school.SchoolResponse;
import com.example.a20190322_bisratfeleke_nycschools.screens.detail.mvp.DetailActivity;
import com.example.a20190322_bisratfeleke_nycschools.screens.main.adapter.MainAdapter;
import com.example.a20190322_bisratfeleke_nycschools.screens.main.adapter.ItemClickListener;
import com.example.a20190322_bisratfeleke_nycschools.screens.main.di.DaggerMainComponent;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View, ItemClickListener {

    @Inject
    MainPresenter presenter;
    private RecyclerView mRecyclerView;

    LinearLayoutManager linearLayoutManager;
    MainAdapter mAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder()
                .appComponent(((App) getApplication()).getAppComponent())
                .mainView(this)
                .build()
                .inject(this);


        presenter.getData(getApplicationContext());
        mRecyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }


    @Override
    public void onDataSuccess(List<SchoolResponse> schoolList) {
        mAdaptor = new MainAdapter(schoolList, this);
        mRecyclerView.setAdapter(mAdaptor);
    }

    @Override
    public void onDataFailure(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        Log.v("Data_Status_Failed", message);
    }


    @Override
    public void onItemClick(SatResponse satResponse, SchoolResponse schoolResponse) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("school_name", schoolResponse.getSchoolName());
        startActivity(intent);
    }

}

