package ${fragmentPackageName};

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import com.justdoit.elementlibrary.base.fragment.BaseTitleFragment;
import com.justdoit.elementlibrary.di.component.AppComponent;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.justdoit.elementlibrary.utils.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;


import ${componentPackageName}.Dagger${pageName}Component;
import ${moudlePackageName}.${pageName}Module;
import ${contractPackageName}.${pageName}Contract;
import ${presenterPackageName}.${pageName}Presenter;
import static com.justdoit.elementlibrary.utils.Preconditions.checkNotNull;

public class ${pageName}Fragment extends BaseTitleFragment<${pageName}Presenter> implements ${pageName}Contract.View{

    public static ${pageName}Fragment newInstance() {
        ${pageName}Fragment fragment = new ${pageName}Fragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(AppComponent appComponent) {
        Dagger${pageName}Component
                .builder()
                .appComponent(appComponent)
                .${extractLetters(pageName[0]?lower_case)}${pageName?substring(1,pageName?length)}Module(new ${pageName}Module(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.${fragmentLayoutName};
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //以下只是提供使用方法,提供了好多方法,自行选择
        getTitleLayout().setText(TitleLayout.BUTTON_CENTER,"标题");
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        
    }

    @Override
    public void setData(Object data) {

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

}