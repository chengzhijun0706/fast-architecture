package com.justdoit.demo.mvp.ui.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.justdoit.demo.R;
import com.justdoit.demo.mvp.model.entity.WeatherInfo;
import com.justdoit.elementlibrary.imageloader.loader.ImageLoader;

import javax.inject.Inject;

public class MainAdapter extends BaseMultiItemQuickAdapter<WeatherInfo, BaseViewHolder> {

    @Inject
    public MainAdapter() {
        super(null);
        addItemType(WeatherInfo.TYPE_CURR_WEATHER, R.layout.item_temperature);
        addItemType(WeatherInfo.TYPE_WEATHER_SUGGEST, R.layout.item_suggestion);
        addItemType(WeatherInfo.TYPE_FUTURE_WEATHER, R.layout.item_future_weather);
    }

    @Override
    protected void convert(BaseViewHolder helper, WeatherInfo item) {
        switch (helper.getItemViewType()) {
            case WeatherInfo.TYPE_CURR_WEATHER:
                helper.setText(R.id.tv_curr_tmp, item.getCurrTmp());
                helper.setText(R.id.tv_min_tmp, item.getMinTmp());
                helper.setText(R.id.tv_max_tmp, item.getMaxTmp());
                ImageLoader.with(mContext).load(item.getWeatherIconRes()).into(helper.getView(R.id.img_weather_icon));
                break;
            case WeatherInfo.TYPE_WEATHER_SUGGEST:
                helper.setText(R.id.tv_title, item.getTitle());
                helper.setText(R.id.tv_disc, item.getDescribe());
                ImageLoader.with(mContext).load(item.getWeatherIconRes()).into(helper.getView(R.id.img_suggestion_icon));
                break;
            case WeatherInfo.TYPE_FUTURE_WEATHER:
                helper.setText(R.id.tv_title, item.getTitle());
                helper.setText(R.id.tv_disc, item.getDescribe());
                helper.setText(R.id.tv_min_max, String.format("%s~%s", item.getMinTmp(), item.getMaxTmp()));
                ImageLoader.with(mContext).load(item.getWeatherIconRes()).into(helper.getView(R.id.img_weather_icon));
                break;
            default:
                break;
        }
    }
}
