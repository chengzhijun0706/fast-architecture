package com.justdoit.demo;

import com.justdoit.demo.mvp.model.entity.Weather;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import io.rx_cache2.LifeCache;
import io.rx_cache2.Reply;

/**
 * @author : chengzhijun
 * @date : 2018/6/25
 * @email : 1031612246@QQ.COM
 * @description :
 */
public interface AppCacheService {

    @LifeCache(duration = 2, timeUnit = TimeUnit.MINUTES)
    Observable<Reply<BaseListResponseEntity<Weather>>> getWeatherList(Observable<BaseListResponseEntity<Weather>> observable,
                                                                      DynamicKey dynamicKey,
                                                                      EvictDynamicKey evictDynamicKey);

}
