package com.example.a20190322_bisratfeleke_nycschools.network;

import com.example.a20190322_bisratfeleke_nycschools.common.Constants;
import com.example.a20190322_bisratfeleke_nycschools.model.SatResponse;
import com.example.a20190322_bisratfeleke_nycschools.model.SchoolResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface WebService {

    @GET(Constants.SCHOOL_END_POINT)
    Single<List<SchoolResponse>> getListOfSchools();


    @GET(Constants.SAT_END_POINT)
    Single<List<SatResponse>> getRequestedDetail();


}
