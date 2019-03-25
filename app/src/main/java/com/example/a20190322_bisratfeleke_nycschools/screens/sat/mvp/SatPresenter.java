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
    private SatContract.View satContractView;
    private WebService webService;

    @Inject
    public SatPresenter(SatContract.View satContractView, WebService webService) {
        this.satContractView = satContractView;
        this.webService = webService;
        disposable = new CompositeDisposable();
    }

    @Override
    public void getDetailData(String dbn) {
        disposable.add(webService.getRequestedDetail(dbn)
               .filter(satResponses -> satResponses != null).subscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread())
                .subscribe(satResponses -> handleResult(satResponses),
                               Throwable::printStackTrace));
    }

    private void handleResult(List<SatResponse> satResponse) {

        if (satResponse != null && !satResponse.isEmpty()) {
            SatResponse response = satResponse.get(0);

            satContractView.onFetchDetail(response.getSatMathAvgScore(),
                    response.getSatCriticalReadingAvgScore(),
                    response.getSatWritingAvgScore(), response.getSchoolName());

        } else {

            satContractView.onError("no data found");

        }


    }








    @Override
    public void stop() {
        disposable.clear();
    }
}
