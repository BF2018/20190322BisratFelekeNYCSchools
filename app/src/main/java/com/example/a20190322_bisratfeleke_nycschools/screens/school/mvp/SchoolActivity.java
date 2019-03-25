package com.example.a20190322_bisratfeleke_nycschools.screens.school.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.a20190322_bisratfeleke_nycschools.R;
import com.example.a20190322_bisratfeleke_nycschools.app.App;
import com.example.a20190322_bisratfeleke_nycschools.model.SchoolResponse;
import com.example.a20190322_bisratfeleke_nycschools.screens.sat.mvp.SatActivity;
import com.example.a20190322_bisratfeleke_nycschools.screens.school.adapter.ItemClickListener;
import com.example.a20190322_bisratfeleke_nycschools.screens.school.adapter.SchoolAdapter;
import com.example.a20190322_bisratfeleke_nycschools.screens.school.di.DaggerSchoolComponent;

import java.util.List;

import javax.inject.Inject;

public class SchoolActivity extends AppCompatActivity implements SchoolContract.View, ItemClickListener {

    @Inject
    SchoolPresenter presenter;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SchoolAdapter schoolAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
        DaggerSchoolComponent.builder()
                .appComponent(((App) getApplication()).getAppComponent())
                .mainView(this)
                .build()
                .inject(this);


        presenter.getData();
        recyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


    @Override
    public void onDataSuccess(List<SchoolResponse> schoolList) {
        schoolAdapter = new SchoolAdapter(schoolList, this);
        recyclerView.setAdapter(schoolAdapter);
    }

    @Override
    public void onDataFailure(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onItemClick(SchoolResponse schoolResponse) {
        Intent intent = new Intent(SchoolActivity.this, SatActivity.class);
        intent.putExtra("dbn", schoolResponse.getDbn());
        startActivity(intent);
    }

}

