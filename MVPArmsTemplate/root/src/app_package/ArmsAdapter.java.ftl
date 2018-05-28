package ${adapterPackageName};

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import ${packageName}.R;
import ${entityPackageName}.${pageName}Info;


import javax.inject.Inject;

public class ${pageName}Adapter extends BaseQuickAdapter<${pageName}Info, BaseViewHolder> {

    @Inject
    public ${pageName}Adapter() {
        super(R.layout.${adapterLayoutName});
    }

    @Override
    protected void convert(BaseViewHolder helper, ${pageName}Info item) {

    }
}
