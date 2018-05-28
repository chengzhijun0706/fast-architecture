package com.justdoit.demo.mvp.model;

import android.app.Application;

import com.justdoit.demo.mvp.contract.MainContract;
import com.justdoit.elementlibrary.di.scope.ActivityScope;
import com.justdoit.elementlibrary.integration.IRepositoryManager;
import com.justdoit.elementlibrary.mvp.BaseModel;

import javax.inject.Inject;


@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {

    @Inject
    Application mApplication;

    @Inject
    public MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mApplication = null;
    }
}