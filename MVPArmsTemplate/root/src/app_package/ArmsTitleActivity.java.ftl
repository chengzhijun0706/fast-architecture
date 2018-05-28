package ${ativityPackageName};


import com.justdoit.elementlibrary.base.activity.BaseTitleActivity;
import com.justdoit.elementlibrary.di.component.AppComponent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.justdoit.elementlibrary.utils.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import ${componentPackageName}.Dagger${pageName}Component;
import ${moudlePackageName}.${pageName}Module;
import ${contractPackageName}.${pageName}Contract;
import ${presenterPackageName}.${pageName}Presenter;

import static com.justdoit.elementlibrary.utils.Preconditions.checkNotNull;

public class ${pageName}Activity extends BaseTitleActivity<${pageName}Presenter> implements ${pageName}Contract.View {

    public static void show(Context context) {
        Intent intent = new Intent(context, ${pageName}Activity.class);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity)context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        Dagger${pageName}Component
                .builder()
                .appComponent(appComponent)
                .${extractLetters(pageName[0]?lower_case)}${pageName?substring(1,pageName?length)}Module(new ${pageName}Module(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.${activityLayoutName};
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {
        super.initWidget(savedInstanceState);

        //以下只是提供使用方法,提供了好多方法,自行选择
        getTitleLayout().setText(TitleLayout.BUTTON_CENTER,"标题");
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ToastUtils.showShort(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        Utils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        scrollToFinishActivity();
    }

    @Override
    public void onBackPressed() {
        scrollToFinishActivity();
    }

}
