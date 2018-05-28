<#assign isActivity=needActivity || needTitleActivity || needRecyclerActivity/> 
<#assign isFragment=needFragment || needTitleFragment || needRecyclerFragment/> 
package ${modelPackageName};

import android.app.Application;
import com.justdoit.elementlibrary.integration.IRepositoryManager;
import com.justdoit.elementlibrary.mvp.BaseModel;

<#if isActivity && isFragment>
import com.justdoit.elementlibrary.di.scope.ActivityScope;
<#elseif isActivity>
import com.justdoit.elementlibrary.di.scope.ActivityScope;
<#elseif isFragment>
import com.justdoit.elementlibrary.di.scope.FragmentScope;
</#if>
import javax.inject.Inject;

import ${contractPackageName}.${pageName}Contract;


<#if isActivity && isFragment>
@ActivityScope
<#elseif isActivity>
@ActivityScope
<#elseif isFragment>
@FragmentScope
</#if>
public class ${pageName}Model extends BaseModel implements ${pageName}Contract.Model{
    
    @Inject
    Application mApplication;

    @Inject
    public ${pageName}Model(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mApplication = null;
    }
}