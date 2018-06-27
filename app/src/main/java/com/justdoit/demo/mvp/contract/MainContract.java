package com.justdoit.demo.mvp.contract;

import com.justdoit.demo.mvp.model.entity.WeatherInfo;
import com.justdoit.elementlibrary.mvp.IModel;
import com.justdoit.elementlibrary.mvp.IView;

import java.util.List;

import io.reactivex.Observable;


public interface MainContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void setData(boolean isRefresh, List<WeatherInfo> weathers);
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {
        Observable<List<WeatherInfo>> getWeatherList(String city, boolean isRefresh);
    }
}
