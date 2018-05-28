<#assign isActivity=needActivity || needTitleActivity || needRecyclerActivity/> 
<#assign isFragment=needFragment || needTitleFragment || needRecyclerFragment/> 
package ${moudlePackageName};

<#if isActivity && isFragment>
import com.justdoit.elementlibrary.di.scope.ActivityScope;
<#elseif isActivity>
import com.justdoit.elementlibrary.di.scope.ActivityScope;
<#elseif isFragment>
import com.justdoit.elementlibrary.di.scope.FragmentScope;
</#if>

import dagger.Module;
import dagger.Provides;

import ${contractPackageName}.${pageName}Contract;
import ${modelPackageName}.${pageName}Model;


@Module
public class ${pageName}Module {
    private ${pageName}Contract.View view;

    /**
     * 构建${pageName}Module时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     * @param view
     */
    public ${pageName}Module(${pageName}Contract.View view) {
        this.view = view;
    }

    <#if isActivity && isFragment>
    @ActivityScope
    <#elseif isActivity>
    @ActivityScope
    <#elseif isFragment>
    @FragmentScope
    </#if>
    @Provides
    ${pageName}Contract.View provide${pageName}View(){
        return this.view;
    }

    <#if isActivity && isFragment>
    @ActivityScope
    <#elseif isActivity>
    @ActivityScope
    <#elseif isFragment>
    @FragmentScope
    </#if>
    @Provides
    ${pageName}Contract.Model provide${pageName}Model(${pageName}Model model){
        return model;
    }
}