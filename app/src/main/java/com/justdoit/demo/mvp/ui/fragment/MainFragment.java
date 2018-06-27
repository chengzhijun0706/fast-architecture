package com.justdoit.demo.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.justdoit.demo.di.component.DaggerMainComponent;
import com.justdoit.demo.di.module.MainModule;
import com.justdoit.demo.mvp.contract.MainContract;
import com.justdoit.demo.mvp.model.entity.WeatherInfo;
import com.justdoit.demo.mvp.presenter.MainPresenter;
import com.justdoit.demo.mvp.ui.adapter.MainAdapter;
import com.justdoit.elementlibrary.base.fragment.BaseRecyclerViewFragment;
import com.justdoit.elementlibrary.di.component.AppComponent;
import com.justdoit.elementlibrary.utils.Utils;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.List;

import static com.justdoit.elementlibrary.utils.Preconditions.checkNotNull;

public class MainFragment extends BaseRecyclerViewFragment<MainPresenter, MainAdapter> implements MainContract.View {

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        DaggerMainComponent
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        super.onLoadMore(refreshLayout);
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
    public void setData(Object data) {

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

    }

    @Override
    public void setData(boolean isRefresh, List<WeatherInfo> weathers) {

    }
}