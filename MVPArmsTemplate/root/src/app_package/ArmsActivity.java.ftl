package ${ativityPackageName};

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.justdoit.elementlibrary.base.activity.BaseActivity;
import com.justdoit.elementlibrary.di.component.AppComponent;
import com.blankj.utilcode.util.ToastUtils;
import com.justdoit.elementlibrary.utils.Utils;

import ${componentPackageName}.Dagger${pageName}Component;
import ${moudlePackageName}.${pageName}Module;
import ${contractPackageName}.${pageName}Contract;
import ${presenterPackageName}.${pageName}Presenter;

import ${packageName}.R;


import static com.justdoit.elementlibrary.utils.Preconditions.checkNotNull;


public class ${pageName}Activity extends BaseActivity<${pageName}Presenter> implements ${pageName}Contract.View {

	public static void show(Context context) {
        Intent intent = new Intent(context, ${pageName}Activity.class);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity)context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        Dagger${pageName}Component
                .builder()
                .appComponent(appComponent)
                .${extractLetters(pageName[0]?lower_case)}${pageName?substring(1,pageName?length)}Module(new ${pageName}Module(this))
                .build()
                .inject(this);
    }

    @Override
    public int getContentView() {
        return R.layout.${activityLayoutName};
    }

    @Override
    public void initWidget(Bundle savedInstanceState) {

    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) { 

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
        finish();
    }
}
