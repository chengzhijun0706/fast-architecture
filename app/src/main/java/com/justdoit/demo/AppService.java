package com.justdoit.demo;

import com.justdoit.demo.mvp.model.entity.Weather;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author : chengzhijun
 * @date : 2018/6/25
 * @email : 1031612246@QQ.COM
 * @description :
 */
public interface AppService {

    @GET(AppUrl.URL_COMMON_WEATHER_NOW)
    Observable<BaseListResponseEntity<Weather>> getNowWeather(@Query("location") String city,
                                                              @Query("key") String key);

    @GET(AppUrl.URL_COMMON_WEATHER_LIFESTYLE)
    Observable<BaseListResponseEntity<Weather>> getLifestylEWeather(@Query("location") String city,
                                                                    @Query("key") String key);

    @GET(AppUrl.URL_COMMON_WEATHER_FORECAST)
    Observable<BaseListResponseEntity<Weather>> getForecastWeather(@Query("location") String city,
                                                                   @Query("key") String key);

}
