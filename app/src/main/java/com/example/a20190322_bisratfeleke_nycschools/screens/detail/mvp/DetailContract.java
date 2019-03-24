package com.example.a20190322_bisratfeleke_nycschools.screens.detail.mvp;

public interface DetailContract {
    interface View {
        void onFetchDetail(String maths, String reading, String writing,String schoolName);

        void onError(String error);
    }

    interface Presenter {
        void getDetailData(String schoolName);

        void stop();
    }
}
