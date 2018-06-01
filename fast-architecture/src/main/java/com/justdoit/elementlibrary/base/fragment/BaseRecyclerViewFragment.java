package com.justdoit.elementlibrary.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.justdoit.elementlibrary.R;
import com.justdoit.elementlibrary.mvp.IPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import javax.inject.Inject;

public abstract class BaseRecyclerViewFragment<P extends IPresenter, A extends BaseQuickAdapter> extends BaseTitleFragment<P>
        implements BaseQuickAdapter.OnItemClickListener, OnRefreshLoadMoreListener, BaseQuickAdapter.OnItemChildClickListener {

    protected SmartRefreshLayout mRefreshLayout;
    protected RecyclerView mRecyclerView;

    @Inject
    @Nullable
    protected A mAdapter;

    @Override
    public int getContentLayoutId() {
        return R.layout.fragment_base_recycler_view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRefreshLayout.setOnRefreshLoadMoreListener(this);

        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemChildClickListener(this);

        RecyclerView.ItemDecoration decoration = getDividerItemDecoration();
        if (decoration != null)
            mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setLayoutManager(getLayoutManager());
        mRecyclerView.setAdapter(mAdapter);
    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(mContext);
    }

    protected RecyclerView.ItemDecoration getDividerItemDecoration() {
        return new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

    }

}
