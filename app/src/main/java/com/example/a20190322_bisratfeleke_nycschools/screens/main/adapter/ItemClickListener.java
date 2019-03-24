package com.example.a20190322_bisratfeleke_nycschools.screens.main.adapter;


import com.example.a20190322_bisratfeleke_nycschools.model.sat.SatResponse;
import com.example.a20190322_bisratfeleke_nycschools.model.school.SchoolResponse;

import io.reactivex.annotations.Nullable;

public interface ItemClickListener {
    void onItemClick(@Nullable SatResponse satResponse, @Nullable SchoolResponse response);
}
