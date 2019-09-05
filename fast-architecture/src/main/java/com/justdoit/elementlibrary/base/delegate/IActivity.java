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
package com.justdoit.elementlibrary.base.delegate;


import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.justdoit.elementlibrary.base.activity.BaseActivity;
import com.justdoit.elementlibrary.base.fragment.BaseFragment;
import com.justdoit.elementlibrary.di.component.AppComponent;
import com.justdoit.elementlibrary.integration.ActivityLifecycle;
import com.justdoit.elementlibrary.integration.cache.Cache;
import com.justdoit.elementlibrary.integration.cache.LruCache;

import org.simple.eventbus.EventBus;


/**
 * ================================================
 * 框架要求框架中的每个 {@link Activity} 都需要实现此类,以满足规范
 *
 * @see BaseActivity
 * Created by JessYan on 26/04/2017 21:42
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface IActivity {

    /**
     * 提供在 {@link Activity} 生命周期内的缓存容器, 可向此 {@link Activity} 存取一些必要的数据
     * 此缓存容器和 {@link Activity} 的生命周期绑定, 如果 {@link Activity} 在屏幕旋转或者配置更改的情况下
     * 重新创建, 那此缓存容器中的数据也会被清空, 如果你想避免此种情况请使用 <a href="https://github.com/JessYanCoding/LifecycleModel">LifecycleModel</a>
     *
     * @return like {@link LruCache}
     */
    @NonNull
    Cache<String, Object> provideCache();

    /**
     * 提供 AppComponent (提供所有的单例对象) 给实现类, 进行 Component 依赖
     *
     * @param appComponent
     */
    void setupActivityComponent(@NonNull AppComponent appComponent);

    /**
     * 是否使用 {@link EventBus}
     *
     * @return
     */
    boolean useEventBus();

    /**
     * 如果 {@link #getContentView()} 返回 0, 框架则不会调用 {@link Activity#setContentView(int)}
     *
     * @return
     */
    int getContentView();

    /**
     * 在ButterKnife注入之前调用
     */
    void beforeBindView();

    /**
     * 初始化 View相关,处理一些view的事件等
     *
     * @param savedInstanceState
     */
    void initWidget(@Nullable Bundle savedInstanceState);

    /**
     * 初始化数据
     *
     * @param savedInstanceState
     */
    void initData(@Nullable Bundle savedInstanceState);

    /**
     * 这个 Activity 是否会使用 Fragment,框架会根据这个属性判断是否注册 {@link FragmentManager.FragmentLifecycleCallbacks}
     * 如果返回{@code false},那意味着这个 Activity 不需要绑定 Fragment,那你再在这个 Activity 中绑定继承于 {@link BaseFragment} 的 Fragment 将不起任何作用
     * @see ActivityLifecycle#registerFragmentCallbacks (Fragment 的注册过程)
     *
     * @return
     */
    boolean useFragment();

    /**
     * 是否使用侧滑返回
     */
    boolean useSlideBack();

    /**
     * 是否同化状态栏
     */
    boolean useImmersion();

    /**
     * 是否使用默认的状态栏高度margin
     */
    boolean userDefaultStatusBarHeightMargin();

}
