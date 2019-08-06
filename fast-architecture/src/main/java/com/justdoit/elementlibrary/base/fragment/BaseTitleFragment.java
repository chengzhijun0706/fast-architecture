package com.justdoit.elementlibrary.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.justdoit.elementlibrary.R;
import com.justdoit.elementlibrary.mvp.IPresenter;
import com.justdoit.elementlibrary.widget.TitleLayout;


/**
 * 带有标题栏的activity
 */
public abstract class BaseTitleFragment<P extends IPresenter> extends BaseFragment<P> {

    protected TitleLayout mLytTitle;
    protected View mViewGradientDivider;
    protected ViewStub mLytContent;
    protected FrameLayout mLytLoading;
    protected FrameLayout mLytEmpty;

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_base_title, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLytTitle = view.findViewById(R.id.lyt_title);
        mViewGradientDivider = view.findViewById(R.id.view_gradient_divider);
        mLytLoading = view.findViewById(R.id.lyt_loading);
        mLytEmpty = view.findViewById(R.id.lyt_empty);
        mLytContent = view.findViewById(R.id.lyt_content);
        mLytContent.setLayoutResource(getContentLayoutId());
        mLytContent.inflate();
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
