/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.justdoit.elementlibrary.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.justdoit.elementlibrary.base.delegate.IFragment;
import com.justdoit.elementlibrary.integration.cache.Cache;
import com.justdoit.elementlibrary.integration.cache.CacheType;
import com.justdoit.elementlibrary.integration.lifecycle.FragmentLifecycleable;
import com.justdoit.elementlibrary.mvp.IPresenter;
import com.justdoit.elementlibrary.utils.Utils;
import com.trello.rxlifecycle3.android.FragmentEvent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

/**
 * ================================================
 * 因为 Java 只能单继承,所以如果要用到需要继承特定 @{@link Fragment} 的三方库,那你就需要自己自定义 @{@link Fragment}
 * 继承于这个特定的 @{@link Fragment},然后再按照 {@link BaseFragment} 的格式,将代码复制过去,记住一定要实现{@link IFragment}
 * <p>
 * Created by JessYan on 22/03/2016
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IFragment, FragmentLifecycleable {
    protected final String TAG = this.getClass().getSimpleName();
    private final BehaviorSubject<FragmentEvent> mLifecycleSubject = BehaviorSubject.create();
    private Cache<String, Object> mCache;
    protected Context mContext;
    @Inject
    @Nullable
    protected P mPresenter;//如果当前页面逻辑简单, Presenter 可以为 null

    private boolean isPrepared;
    private boolean isLoadedOnce;

    @NonNull
    @Override
    public synchronized Cache<String, Object> provideCache() {
        if (mCache == null) {
            mCache = Utils.obtainAppComponentFromContext(getActivity()).cacheFactory().build(CacheType.FRAGMENT_CACHE);
        }
        return mCache;
    }

    @NonNull
    @Override
    public final Subject<FragmentEvent> provideLifecycleSubject() {
        return mLifecycleSubject;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Do something
        beforeBindView();
        // Bind view
        ButterKnife.bind(this, view);

        isPrepared = true;
        if (getUserVisibleHint() && !isLoadedOnce) {
            lazyLoadData();
            isLoadedOnce = true;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDestroy();
        this.mPresenter = null;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isPrepared)
            return;

        if (isVisibleToUser) {
            if (!isLoadedOnce) {
                lazyLoadData();// 懒加载
                isLoadedOnce = true;
            } else {
                onResumeWithViewPager();
            }
        } else {
            onPauseWithViewPager();
        }
    }

    /**
     * 是否使用eventBus,默认为使用(true)，
     *
     * @return
     */
    @Override
    public boolean useEventBus() {
        return true;
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void lazyLoadData() {

    }

    @Override
    public void beforeBindView() {

    }

    /**
     * 页面不可见，只和viewpager一起使用的时候调用
     */
    protected void onPauseWithViewPager() {

    }

    /**
     * 页面可见，只和viewpager一起使用的时候调用
     */
    protected void onResumeWithViewPager() {

    }
}
