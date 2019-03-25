package com.example.a20190322_bisratfeleke_nycschools;


import com.example.a20190322_bisratfeleke_nycschools.model.SchoolResponse;
import com.example.a20190322_bisratfeleke_nycschools.network.WebService;
import com.example.a20190322_bisratfeleke_nycschools.screens.school.mvp.SchoolContract;
import com.example.a20190322_bisratfeleke_nycschools.screens.school.mvp.SchoolPresenter;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.plugins.RxJavaPlugins;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SchoolPresenterTest {

    @Mock
    private WebService webService;

    @Mock
    private SchoolContract.View view;

    @Mock
    private SchoolResponse schoolResponse;

    private InOrder inOrder;

    private List<SchoolResponse> schoolResponseList;

    private SchoolPresenter presenter;


    @BeforeClass
    public static void setupRxSchedulers() {
        Scheduler scheduler = new Scheduler() {
            @Override
            public Worker createWorker() {
                return new ExecutorScheduler.ExecutorWorker(Runnable::run);
            }
        };
        RxJavaPlugins.setInitIoSchedulerHandler(schedulerCallable -> scheduler);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> scheduler);
    }

    @Before
    public void setUp() {
        presenter = new SchoolPresenter(view, webService);
        schoolResponseList = Collections.singletonList(schoolResponse);
        inOrder = inOrder(view, webService);
        when(webService.getListOfSchools()).thenReturn((Single.just(schoolResponseList)));
    }


    @Test
    public void getData_IsData_Fetched_ShowsResult() {
        presenter.getData();
        inOrder.verify(view).onDataSuccess(schoolResponseList);
        inOrder.verifyNoMoreInteractions();
    }
}