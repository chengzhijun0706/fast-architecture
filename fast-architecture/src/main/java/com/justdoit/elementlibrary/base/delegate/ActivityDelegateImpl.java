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

import com.justdoit.elementlibrary.utils.Utils;

import org.simple.eventbus.EventBus;

import timber.log.Timber;

/**
 * ================================================
 * {@link ActivityDelegate} 默认实现类
 * <p>
 * Created by JessYan on 26/04/2017 20:23
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class ActivityDelegateImpl implements ActivityDelegate {
    private Activity mActivity;
    private IActivity iActivity;

    public ActivityDelegateImpl(@NonNull Activity activity) {
        this.mActivity = activity;
        this.iActivity = (IActivity) activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Timber.i("onCreate");
        //如果要使用 EventBus 请将此方法返回 true
        if (iActivity.useEventBus()){
            //注册到事件主线
            EventBus.getDefault().register(mActivity);
        }

        //这里提供 AppComponent 对象给 BaseActivity 的子类, 用于 Dagger2 的依赖注入
        iActivity.setupActivityComponent(Utils.obtainAppComponentFromContext(mActivity));
    }

    @Override
    public void onStart() {
        Timber.i("onStart");
    }

    @Override
    public void onResume() {
        Timber.i("onResume");
    }

    @Override
    public void onPause() {
        Timber.i("onPause");
    }

    @Override
    public void onStop() {
        Timber.i("onStop");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Timber.i("onSaveInstanceState");
    }

    @Override
    public void onDestroy() {
        Timber.i("onDestroy");
        //如果要使用 EventBus 请将此方法返回 true
        if (iActivity != null && iActivity.useEventBus())
            EventBus.getDefault().unregister(mActivity);
        this.iActivity = null;
        this.mActivity = null;
    }
}
