package com.example.a20190322_bisratfeleke_nycschools.network;

import com.example.a20190322_bisratfeleke_nycschools.model.sat.SatResponse;
import com.example.a20190322_bisratfeleke_nycschools.model.school.SchoolResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface WebService {

    @GET("resource/s3k6-pzi2.json")
    Single<List<SchoolResponse>> getListOfSchools();


    @GET("resource/f9bf-2cp4.json")
    Single<List<SatResponse>> getRequestedDetail();


}
