package com.example.a20190322_bisratfeleke_nycschools.screens.school.mvp;

import com.example.a20190322_bisratfeleke_nycschools.model.SchoolResponse;
import com.example.a20190322_bisratfeleke_nycschools.network.WebService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class SchoolPresenter implements SchoolContract.Presenter {

    private final CompositeDisposable compositeDisposable;
    private SchoolContract.View schoolContractView;
    private WebService webService;


    @Inject
    public SchoolPresenter(SchoolContract.View view, WebService webServices) {
        this.schoolContractView = view;
        this.webService = webServices;
        compositeDisposable = new CompositeDisposable();
    }


    @Override
    public void getData() {

        compositeDisposable.add(webService.getListOfSchools()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<SchoolResponse>>() {
                    @Override
                    public void onSuccess(List<SchoolResponse> schoolResults) {
                        schoolContractView.onDataSuccess(schoolResults);
                    }

                    @Override
                    public void onError(Throwable e) {
                        schoolContractView.onDataFailure(e.getMessage());
                    }
                })


        );

    }


}
