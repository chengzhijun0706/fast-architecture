package com.justdoit.demo.mvp.model;

import android.app.Application;

import com.blankj.utilcode.util.TimeUtils;
import com.justdoit.demo.AppCacheService;
import com.justdoit.demo.AppService;
import com.justdoit.demo.BaseListResponseEntity;
import com.justdoit.demo.BuildConfig;
import com.justdoit.demo.R;
import com.justdoit.demo.mvp.contract.MainContract;
import com.justdoit.demo.mvp.model.entity.Weather;
import com.justdoit.demo.mvp.model.entity.WeatherInfo;
import com.justdoit.elementlibrary.di.scope.ActivityScope;
import com.justdoit.elementlibrary.integration.IRepositoryManager;
import com.justdoit.elementlibrary.mvp.BaseModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.Reply;


@ActivityScope
public class MainModel extends BaseModel implements MainContract.Model {

    @Inject
    Application mApplication;

    @Inject
    public MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mApplication = null;
    }

    @Override
    public Observable<List<WeatherInfo>> getWeatherList(String city, boolean isRefresh) {
        //使用rxcache缓存,下拉刷新则不读取缓存,加载更多读取缓存
        return mRepositoryManager
                .obtainCacheService(AppCacheService.class)
                .getWeatherList(mRepositoryManager
                        .obtainRetrofitService(AppService.class)
                        .getWeatherList(city, BuildConfig.WEATHER_KEY), new DynamicKey(city), new EvictDynamicKey(isRefresh))
                .map(Reply::getData)
                .map(BaseListResponseEntity::getData)
                .map(weathers -> {
                    List<WeatherInfo> infos = new ArrayList<>();
                    WeatherInfo currWeather = new WeatherInfo();
                    Weather weather = weathers.get(0);
                    currWeather.setLocation(weather.getBasic().getLocation());
                    currWeather.setItemType(WeatherInfo.TYPE_CURR_WEATHER);
                    currWeather.setCurrTmp(String.format("%s℃",weather.getNow().getTmp()));
                    currWeather.setMaxTmp(String.format("↑ %s°",weather.getDailyForecast().get(0).getTmpMax()));
                    currWeather.setMinTmp(String.format("↓ %s°",weather.getDailyForecast().get(0).getTmpMin()));
                    currWeather.setWeatherIconRes(getWeatherIconResFromText(weather.getNow().getCondTxt()));
                    infos.add(currWeather);

                    for (Weather.LifestyleEntity entity:weather.getSuggestion()) {
                        WeatherInfo suggestion = new WeatherInfo();
                        suggestion.setItemType(WeatherInfo.TYPE_WEATHER_SUGGEST);
                        switch (entity.getType()) {
                            case "drsg":
                                suggestion.setTitle(String.format("穿衣指数---%s", entity.getBrf()));
                                suggestion.setDescribe(entity.getTxt());
                                suggestion.setWeatherIconRes(R.mipmap.icon_cloth);
                                infos.add(suggestion);
                                break;
                            case "sport":
                                suggestion.setTitle(String.format("运动指数---%s", entity.getBrf()));
                                suggestion.setDescribe(entity.getTxt());
                                suggestion.setWeatherIconRes(R.mipmap.icon_sport);
                                infos.add(suggestion);
                                break;
                            case "trav":
                                suggestion.setTitle(String.format("旅游指数---%s", entity.getBrf()));
                                suggestion.setDescribe(entity.getTxt());
                                suggestion.setWeatherIconRes(R.mipmap.icon_travel);
                                infos.add(suggestion);
                                break;
                            case "flu":
                                suggestion.setTitle(String.format("感冒指数---%s", entity.getBrf()));
                                suggestion.setDescribe(entity.getTxt());
                                suggestion.setWeatherIconRes(R.mipmap.icon_flu);
                                infos.add(suggestion);
                                break;
                            default:
                                break;
                        }
                    }

                    for (Weather.DailyForecastEntity entity:weather.getDailyForecast()) {
                        WeatherInfo futureWeather = new WeatherInfo();
                        futureWeather.setItemType(WeatherInfo.TYPE_FUTURE_WEATHER);
                        futureWeather.setWeatherIconRes(getWeatherIconResFromText(entity.getCondTxtD()));
                        futureWeather.setMaxTmp(String.format("%s°",entity.getTmpMax()));
                        futureWeather.setMinTmp(String.format("%s°",entity.getTmpMin()));
                        futureWeather.setDescribe(String.format("%s。 最高%s℃。%s级%s %skm/h。 降水几率%s%%",
                                entity.getCondTxtD(), entity.getTmpMax(), entity.getWindSc(), entity.getWindDir(), entity.getWindSpd(), entity.getPop()));
                        switch (TimeUtils.getFitTimeSpanByNow(entity.getDate(),new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()),1)) {
                            case "0天":
                                futureWeather.setTitle("今天");
                                break;
                            case "1天":
                                futureWeather.setTitle("明天");
                                break;
                            default:
                                futureWeather.setTitle(TimeUtils.getChineseWeek(entity.getDate(),new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())));
                                break;
                        }
                        infos.add(futureWeather);
                    }
                    return infos;
                });
    }

    private int getWeatherIconResFromText(String text) {
        switch (text) {
            case"晴":
                return R.mipmap.type_two_sunny;
            case"阴":
                return R.mipmap.type_two_cloudy;
            case"多云":
                return R.mipmap.type_two_cloudy;
            case"少云":
                return R.mipmap.type_two_cloudy;
            case"晴间多云":
                return R.mipmap.type_two_cloudytosunny;
            case"小雨":
                return R.mipmap.type_two_light_rain;
            case"中雨":
                return R.mipmap.type_two_rain;
            case"大雨":
                return R.mipmap.type_two_rain;
            case"阵雨":
                return R.mipmap.type_two_rain;
            case"雷阵雨":
                return R.mipmap.type_two_thunderstorm;
            case"霾":
                return R.mipmap.type_two_haze;
            case"雾":
                return R.mipmap.type_two_fog;
            case"雨夹雪":
                return R.mipmap.type_two_snowrain;
            case"未知":
            default:
                return R.mipmap.none;
        }
    }
}