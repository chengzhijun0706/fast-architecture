package com.justdoit.demo;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;

import com.justdoit.elementlibrary.base.fragment.BaseTitleFragment;
import com.justdoit.elementlibrary.di.component.AppComponent;
import com.justdoit.elementlibrary.widget.TitleLayout;

/**
 * @author : chengzhijun
 * @date : 2018/5/21
 * @email : 1031612246@QQ.COM
 * @description :
 */
public class MainFragment extends BaseTitleFragment {
    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getTitleLayout().setText(TitleLayout.BUTTON_CENTER,"标题");
    }

    @Override
    protected int getContentLayoutId() {
        return 0;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }
}
