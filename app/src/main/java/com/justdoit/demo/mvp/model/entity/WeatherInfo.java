package com.justdoit.demo.mvp.model.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

public class WeatherInfo implements Serializable, MultiItemEntity {

    public static final int TYPE_CURR_WEATHER    = 0x01;
    public static final int TYPE_FUTURE_WEATHER  = 0x02;
    public static final int TYPE_WEATHER_SUGGEST = 0x03;

    private int itemType;
    private int weatherIconRes;
    private String currTmp;
    private String minTmp;
    private String maxTmp;
    private String time;
    private String title;
    private String describe;
    private String weatherText;
    private String location;


    public int getWeatherIconRes() {
        return weatherIconRes;
    }

    public void setWeatherIconRes(int weatherIconRes) {
        this.weatherIconRes = weatherIconRes;
    }

    public String getCurrTmp() {
        return currTmp;
    }

    public void setCurrTmp(String currTmp) {
        this.currTmp = currTmp;
    }

    public String getMinTmp() {
        return minTmp;
    }

    public void setMinTmp(String minTmp) {
        this.minTmp = minTmp;
    }

    public String getMaxTmp() {
        return maxTmp;
    }

    public void setMaxTmp(String maxTmp) {
        this.maxTmp = maxTmp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
