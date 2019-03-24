package com.example.a20190322_bisratfeleke_nycschools.screens.main.mvp;

import android.content.Context;

import com.example.a20190322_bisratfeleke_nycschools.model.school.SchoolResponse;
import com.example.a20190322_bisratfeleke_nycschools.network.WebService;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {

    private final CompositeDisposable mDisposible;
    private MainContract.View mainContractView;
    private WebService webService;


    @Inject
    public MainPresenter(MainContract.View view, WebService webServices) {
        this.mainContractView = view;
        this.webService = webServices;
        mDisposible = new CompositeDisposable();
    }


    @Override
    public void getData(Context context) {

        mDisposible.add(webService.getListOfSchools()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<SchoolResponse>>() {
                    @Override
                    public void onSuccess(List<SchoolResponse> schoolResults) {
                        mainContractView.onDataSuccess(schoolResults);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainContractView.onDataFailure(e.getMessage());
                    }
                })


        );

    }


}
