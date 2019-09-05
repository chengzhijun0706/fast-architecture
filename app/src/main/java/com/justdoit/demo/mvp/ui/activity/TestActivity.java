package com.justdoit.demo.mvp.ui.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.justdoit.demo.MainFragment;
import com.justdoit.demo.R;
import com.justdoit.elementlibrary.base.activity.BaseActivity;
import com.justdoit.elementlibrary.di.component.AppComponent;

/**
 * @author : chengzhijun
 * @date : 2019-09-05
 * @email : 1031612246@QQ.COM
 * @description :
 */
public class TestActivity extends BaseActivity {


    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_test;
    }

    @Override
    public void initWidget(@Nullable Bundle savedInstanceState) {
        replaceFragment(R.id.container, new MainFragment());
    }

    @Override
    public boolean useImmersion() {
        return false;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }
}
