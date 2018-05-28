package com.justdoit.demo.mvp.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import com.justdoit.demo.R;
import com.justdoit.demo.mvp.model.entity.MainInfo;


import javax.inject.Inject;

public class MainAdapter extends BaseQuickAdapter<MainInfo, BaseViewHolder> {

    @Inject
    public MainAdapter() {
        super(R.layout.item_main);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainInfo item) {

    }
}
