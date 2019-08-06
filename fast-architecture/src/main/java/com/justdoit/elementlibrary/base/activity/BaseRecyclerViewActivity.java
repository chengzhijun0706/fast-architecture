package com.justdoit.elementlibrary.base.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.justdoit.elementlibrary.R;
import com.justdoit.elementlibrary.mvp.IPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import javax.inject.Inject;

public abstract class BaseRecyclerViewActivity<P extends IPresenter, A extends BaseQuickAdapter> extends BaseTitleActivity<P>
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
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRefreshLayout = findViewById(R.id.refreshLayout);

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
        return new LinearLayoutManager(this);
    }

    protected RecyclerView.ItemDecoration getDividerItemDecoration() {
        return new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
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
