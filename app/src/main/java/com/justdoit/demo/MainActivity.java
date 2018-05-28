package com.justdoit.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.justdoit.elementlibrary.base.activity.BaseActivity;
import com.justdoit.elementlibrary.di.component.AppComponent;
import com.justdoit.elementlibrary.di.scope.ActivityScope;
import com.justdoit.elementlibrary.di.scope.FragmentScope;
import com.justdoit.elementlibrary.imageloader.loader.ImageLoader;

import butterknife.OnClick;
import timber.log.Timber;

@FragmentScope
@ActivityScope
public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Override
    @OnClick(R.id.image)
    public void onClick(View v) {
        ImageLoader.with(this)
                .placeHolder(R.mipmap.ic_launcher)
                .asCircle()
                .load("https://static.jinrongbaguanv.com/o_1cdgtbj4a1fnt16uf2rr1jmv1db9f.jpg?imageMogr2/thumbnail/!68p/crop/!750x520a42a1")
                .into(v);
        Timber.e("listddddd");

    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int getContentView() {
        return R.layout.activity_test;
    }

    @Override
    public void initWidget(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }
}
