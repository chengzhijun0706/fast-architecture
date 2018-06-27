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

    @GET(AppUrl.URL_COMMON_WEATHER)
    Observable<BaseListResponseEntity<Weather>> getWeatherList(@Query("location") String city,
                                                               @Query("key") String key);

}
