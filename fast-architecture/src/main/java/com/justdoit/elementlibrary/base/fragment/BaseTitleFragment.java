package com.justdoit.elementlibrary.base.fragment;

import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;

import com.justdoit.elementlibrary.R;
import com.justdoit.elementlibrary.R2;
import com.justdoit.elementlibrary.mvp.IPresenter;
import com.justdoit.elementlibrary.widget.TitleLayout;

import butterknife.BindView;


/**
 * 带有标题栏的activity
 */
public abstract class BaseTitleFragment<P extends IPresenter> extends BaseFragment<P> {

    @BindView(R2.id.lyt_title)
    TitleLayout mLytTitle;
    @BindView(R2.id.view_gradient_divider)
    View mViewGradientDivider;
    @BindView(R2.id.lyt_content)
    ViewStub mLytContent;
    @BindView(R2.id.lyt_loading)
    FrameLayout mLytLoading;
    @BindView(R2.id.lyt_empty)
    FrameLayout mLytEmpty;

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_base_title, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
