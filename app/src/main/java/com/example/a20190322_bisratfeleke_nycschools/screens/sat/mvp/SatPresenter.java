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
                            .filter(satResponses -> {
                                return satResponses != null;
                    }).subscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread())
                       .subscribe(satResponses -> handleResult(satResponses, schoolName),
                               Throwable::printStackTrace));
    }

    private void handleResult(List<SatResponse> satResponse , String schoolName) {
        String bar[] = schoolName.toUpperCase().split(" ", 3);
        StringBuilder builder = new StringBuilder();


        if (satResponse != null) {
            for (SatResponse response : satResponse) {

                if (response.getSchoolName().contains(schoolName.toUpperCase())) {

                    detailContractView.onFetchDetail(response.getSatMathAvgScore(),
                            response.getSatCriticalReadingAvgScore(),
                            response.getSatWritingAvgScore(), response.getSchoolName());

                } else if (response.getSchoolName().startsWith(builder.append(bar[0]).toString())){
                    detailContractView.onFetchDetail(response.getSatMathAvgScore(),
                            response.getSatCriticalReadingAvgScore(),
                            response.getSatWritingAvgScore(), response.getSchoolName());


                } else if (response.getSchoolName().startsWith(builder.append(bar[1]).toString())) {
                    detailContractView.onFetchDetail(response.getSatMathAvgScore(),
                            response.getSatCriticalReadingAvgScore(),
                            response.getSatWritingAvgScore(), response.getSchoolName());

                }else if (response.getSchoolName().startsWith(builder.append(bar[2]).toString())) {
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
