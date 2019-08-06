package com.justdoit.elementlibrary.base.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.justdoit.elementlibrary.R;
import com.justdoit.elementlibrary.mvp.IPresenter;
import com.justdoit.elementlibrary.widget.TitleLayout;


/**
 * 带有标题栏的activity
 */
public abstract class BaseTitleActivity<P extends IPresenter> extends BaseActivity<P> {

    TitleLayout mLytTitle;
    View mViewGradientDivider;
    FrameLayout mLytLoading;
    FrameLayout mLytEmpty;

    @Override
    public int getContentView() {
        return R.layout.activity_base_title;
    }

    @Override
    public void beforeBindView() {
        super.beforeBindView();
        mLytTitle = findViewById(R.id.lyt_title);
        mViewGradientDivider = findViewById(R.id.view_gradient_divider);
        mLytLoading = findViewById(R.id.lyt_loading);
        mLytEmpty = findViewById(R.id.lyt_empty);
        ViewStub content = findViewById(R.id.lyt_content);
        content.setLayoutResource(getContentLayoutId());
        content.inflate();
    }

    @Override
    public void initWidget(@Nullable Bundle savedInstanceState) {

    }

    public TitleLayout getTitleLayout() {
        return mLytTitle;
    }

    public void setTitleShow(boolean show) {
        mLytTitle.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void setShowDivider(boolean show) {
        mViewGradientDivider.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void setLoadingView(View view) {
        mLytLoading.removeAllViews();
        mLytLoading.addView(view);
    }

    public void setEmptyView(View view) {
        mLytLoading.removeAllViews();
        mLytLoading.addView(view);
    }

    public void showEmptyView() {
        mLytEmpty.setVisibility(View.VISIBLE);
    }

    public void dismissEmptyView() {
        mLytEmpty.setVisibility(View.GONE);
    }

    public void showLoadingView() {
        mLytLoading.setVisibility(View.VISIBLE);
    }

    public void dismissLoadingView() {
        mLytLoading.setVisibility(View.GONE);
    }

    protected abstract @LayoutRes
    int getContentLayoutId();

}
