<#assign isActivity=needActivity || needTitleActivity || needRecyclerActivity/> 
<#assign isFragment=needFragment || needTitleFragment || needRecyclerFragment/> 
package ${presenterPackageName};

import android.app.Application;

<#if isActivity && isFragment>
import com.justdoit.elementlibrary.di.scope.ActivityScope;
<#elseif isActivity>
import com.justdoit.elementlibrary.di.scope.ActivityScope;
<#elseif isFragment>
import com.justdoit.elementlibrary.di.scope.FragmentScope;
</#if>
import com.justdoit.elementlibrary.mvp.BasePresenter;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import javax.inject.Inject;

import ${contractPackageName}.${pageName}Contract;



<#if isActivity && isFragment>
@ActivityScope
<#elseif isActivity>
@ActivityScope
<#elseif isFragment>
@FragmentScope
</#if>
public class ${pageName}Presenter extends BasePresenter<${pageName}Contract.Model, ${pageName}Contract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;

    @Inject
    public ${pageName}Presenter (${pageName}Contract.Model model, ${pageName}Contract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mApplication = null;
    }
}
