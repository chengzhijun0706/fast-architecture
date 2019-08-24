package ${fragmentPackageName};

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import com.justdoit.elementlibrary.base.fragment.BaseRecyclerViewFragment;
import com.justdoit.elementlibrary.di.component.AppComponent;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.justdoit.elementlibrary.utils.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;


import ${componentPackageName}.Dagger${pageName}Component;
import ${moudlePackageName}.${pageName}Module;
import ${contractPackageName}.${pageName}Contract;
import ${presenterPackageName}.${pageName}Presenter;
import ${adapterPackageName}.${pageName}Adapter;
import static com.justdoit.elementlibrary.utils.Preconditions.checkNotNull;

public class ${pageName}Fragment extends BaseRecyclerViewFragment<${pageName}Presenter,${pageName}Adapter> implements ${pageName}Contract.View{

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        
    }

    @Override
     public void onRefresh(RefreshLayout refreshlayout) {
         super.onRefresh(refreshlayout);
     }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        super.onLoadMore(refreshLayout);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        super.onItemClick(adapter, view, position);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        super.onItemChildClick(adapter, view, position);
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