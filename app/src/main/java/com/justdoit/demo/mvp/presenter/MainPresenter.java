package com.justdoit.demo.mvp.presenter;

import android.app.Application;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import com.justdoit.demo.mvp.contract.MainContract;
import com.justdoit.demo.mvp.model.entity.WeatherInfo;
import com.justdoit.elementlibrary.di.scope.ActivityScope;
import com.justdoit.elementlibrary.mvp.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;


@ActivityScope
public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;

    @Inject
    public MainPresenter(MainContract.Model model, MainContract.View rootView) {
        super(model, rootView);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume() {
        getWeatherData(true);
    }

    public void getWeatherData(boolean isRefresh) {
        mModel.getWeatherList("auto_ip", isRefresh)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retryWhen(new RetryWithDelay(3, 2))
                .subscribe(new ErrorHandleSubscriber<List<WeatherInfo>>(mErrorHandler) {
                    @Override
                    public void onNext(List<WeatherInfo> weatherInfos) {
                        mRootView.setData(isRefresh, weatherInfos);
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        //可以自己实现单独的onError,不实现就会使用在GlobalConfiguration中配置的ResponseErrorListenerImpl
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mApplication = null;
    }
}
