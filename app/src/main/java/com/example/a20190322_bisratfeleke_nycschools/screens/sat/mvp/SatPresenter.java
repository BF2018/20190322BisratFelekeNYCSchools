package com.example.a20190322_bisratfeleke_nycschools.screens.sat.mvp;


import com.example.a20190322_bisratfeleke_nycschools.model.SatResponse;
import com.example.a20190322_bisratfeleke_nycschools.network.WebService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class SatPresenter implements SatContract.Presenter {

    private final CompositeDisposable disposable;
    private SatContract.View detailContractView;
    private WebService webService;

    @Inject
    public SatPresenter(SatContract.View detailContractView, WebService webService) {
        this.detailContractView = detailContractView;
        this.webService = webService;
        disposable = new CompositeDisposable();
    }

    @Override
    public void getDetailData(String schoolName) {
       disposable.add(webService.getRequestedDetail()
               .filter(satResponses -> satResponses != null).subscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread())
                       .subscribe(satResponses -> handleResult(satResponses, schoolName),
                               Throwable::printStackTrace));
    }

    private void handleResult(List<SatResponse> satResponse , String schoolName) {
        String bar[] = schoolName.toUpperCase().split(" ", 3);



        if (satResponse != null) {
            for (SatResponse response : satResponse) {

                if (response.getSchoolName().contains(schoolName.toUpperCase()) ||
                        response.getSchoolName().startsWith(bar[0]) ||
                        response.getSchoolName().startsWith(bar[1]) ||
                        response.getSchoolName().startsWith(bar[2])) {

                    detailContractView.onFetchDetail(response.getSatMathAvgScore(),
                            response.getSatCriticalReadingAvgScore(),
                            response.getSatWritingAvgScore(), response.getSchoolName());

                }
            }


        }

    }


    @Override
    public void stop() {
        disposable.clear();
    }
}
