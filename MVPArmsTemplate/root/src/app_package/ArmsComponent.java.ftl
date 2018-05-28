<#assign isActivity=needActivity || needTitleActivity || needRecyclerActivity/> 
<#assign isFragment=needFragment || needTitleFragment || needRecyclerFragment/> 
package ${componentPackageName};

import dagger.Component;
import com.justdoit.elementlibrary.di.component.AppComponent;

import ${moudlePackageName}.${pageName}Module;

<#if isActivity && isFragment>
import com.justdoit.elementlibrary.di.scope.ActivityScope;
import ${ativityPackageName}.${pageName}Activity;
import ${fragmentPackageName}.${pageName}Fragment;
<#elseif isActivity>
import com.justdoit.elementlibrary.di.scope.ActivityScope;
import ${ativityPackageName}.${pageName}Activity;   
<#elseif isFragment>
import com.justdoit.elementlibrary.di.scope.FragmentScope;
import ${fragmentPackageName}.${pageName}Fragment;
</#if>

<#if isActivity && isFragment>
@ActivityScope
<#elseif isActivity>
@ActivityScope
<#elseif isFragment>
@FragmentScope
</#if>
@Component(modules = ${pageName}Module.class,dependencies = AppComponent.class)
public interface ${pageName}Component {
  <#if isActivity && isFragment>
	void inject(${pageName}Activity activity);
	void inject(${pageName}Fragment fragment);
  <#elseif isActivity || isFragment>
    void inject(<#if isFragment>${pageName}Fragment fragment<#else>${pageName}Activity activity</#if>);
  </#if>
}