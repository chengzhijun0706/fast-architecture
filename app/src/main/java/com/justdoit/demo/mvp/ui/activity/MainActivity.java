package com.justdoit.demo.mvp.ui.activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.justdoit.demo.R;
import com.justdoit.demo.di.component.DaggerMainComponent;
import com.justdoit.demo.di.module.MainModule;
import com.justdoit.demo.mvp.contract.MainContract;
import com.justdoit.demo.mvp.model.entity.WeatherInfo;
import com.justdoit.demo.mvp.presenter.MainPresenter;
import com.justdoit.demo.mvp.ui.adapter.MainAdapter;
import com.justdoit.elementlibrary.base.activity.BaseRecyclerViewActivity;
import com.justdoit.elementlibrary.di.component.AppComponent;
import com.justdoit.elementlibrary.utils.Utils;
import com.justdoit.elementlibrary.widget.TitleLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.List;

import static com.justdoit.elementlibrary.utils.Preconditions.checkNotNull;

public class MainActivity extends BaseRecyclerViewActivity<MainPresenter, MainAdapter> implements MainContract.View {

    public static void show(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        mRefreshLayout.setEnableLoadMore(false);
        getTitleLayout().setButtonVisibility(TitleLayout.BUTTON_LEFT, View.GONE);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ToastUtils.showShort(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        Utils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        scrollToFinishActivity();
    }

    @Override
    public void onBackPressed() {
        scrollToFinishActivity();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
        mPresenter.getWeatherData(true);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        super.onLoadMore(refreshLayout);
        mPresenter.getWeatherData(false);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        super.onItemClick(adapter, view, position);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        super.onItemChildClick(adapter, view, position);
    }

    @Override
    public void setData(boolean isRefresh, List<WeatherInfo> weathers) {
        if (isRefresh) {
            getTitleLayout().setText(TitleLayout.BUTTON_CENTER, weathers.get(0).getLocation());
            mAdapter.setNewData(weathers);
            mRefreshLayout.finishRefresh();
        } else {
            mAdapter.addData(weathers);
            mRefreshLayout.finishLoadMore();
        }
    }
}
