package com.justdoit.demo.mvp.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Weather implements Serializable {


    @SerializedName("basic")
    private BasicEntity basic;

    @SerializedName("update")
    private UpdateEntity update;

    @SerializedName("now")
    private NowEntity now;

    /**
     * status : ok
     */
    @SerializedName("status")
    private String status;

    @SerializedName("lifestyle")
    private List<LifestyleEntity> suggestion;

    @SerializedName("daily_forecast")
    private List<DailyForecastEntity> dailyForecast;

    public static class BasicEntity implements Serializable {
        /**
         "cid":"CN101010100",
         "location":"北京",
         "parent_city":"北京",
         "admin_area":"北京",
         "cnty":"中国",
         "lat":"39.90498734",
         "lon":"116.4052887",
         "tz":"+8.00"
         */
        @SerializedName("location")
        private String location;
        @SerializedName("parent_city")
        private String parentCity;
        @SerializedName("admin_area")
        private String adminArea;
        @SerializedName("cnty")
        private String cnty;
        @SerializedName("cid")
        private String id;
        @SerializedName("lat")
        private String lat;
        @SerializedName("lon")
        private String lon;

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getCnty() {
            return cnty;
        }

        public void setCnty(String cnty) {
            this.cnty = cnty;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        @Override
        public String toString() {
            return "BasicEntity{" +
                    "location='" + location + '\'' +
                    ", parentCity='" + parentCity + '\'' +
                    ", adminArea='" + adminArea + '\'' +
                    ", cnty='" + cnty + '\'' +
                    ", id='" + id + '\'' +
                    ", lat='" + lat + '\'' +
                    ", lon='" + lon + '\'' +
                    '}';
        }
    }

    public static class UpdateEntity implements Serializable {
        /**
         * loc : 2016-02-18 21:04
         * utc : 2016-02-18 13:04
         */
        @SerializedName("loc")
        private String loc;
        @SerializedName("utc")
        private String utc;

        public String getLoc() {
            return loc;
        }

        public void setLoc(String loc) {
            this.loc = loc;
        }

        public String getUtc() {
            return utc;
        }

        public void setUtc(String utc) {
            this.utc = utc;
        }

        @Override
        public String toString() {
            return "UpdateEntity{" +
                    "loc='" + loc + '\'' +
                    ", utc='" + utc + '\'' +
                    '}';
        }
    }

    public static class NowEntity implements Serializable {

        /**
         "cloud":"0",
         "cond_code":"104",
         "cond_txt":"阴",
         "fl":"30",
         "hum":"53",
         "pcpn":"0.0",
         "pres":"1002",
         "tmp":"29",
         "vis":"8",
         "wind_deg":"185",
         "wind_dir":"南风",
         "wind_sc":"2",
         "wind_spd":"8"
         */
        @SerializedName("cloud")
        private String cloud;
        @SerializedName("cond_code")
        private String condCode;
        @SerializedName("cond_txt")
        private String condTxt;
        @SerializedName("fl")
        private String fl;
        @SerializedName("hum")
        private String hum;
        @SerializedName("pcpn")
        private String pcpn;
        @SerializedName("pres")
        private String pres;
        @SerializedName("tmp")
        private String tmp;
        @SerializedName("vis")
        private String vis;
        @SerializedName("wind_deg")
        private String windDeg;
        @SerializedName("wind_dir")
        private String windDir;
        @SerializedName("wind_sc")
        private String windSc;
        @SerializedName("wind_spd")
        private String windSpd;

        public String getCloud() {
            return cloud;
        }

        public void setCloud(String cloud) {
            this.cloud = cloud;
        }

        public String getCondCode() {
            return condCode;
        }

        public void setCondCode(String condCode) {
            this.condCode = condCode;
        }

        public String getCondTxt() {
            return condTxt;
        }

        public void setCondTxt(String condTxt) {
            this.condTxt = condTxt;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getPcpn() {
            return pcpn;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public String getTmp() {
            return tmp;
        }

        public void setTmp(String tmp) {
            this.tmp = tmp;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public String getWindDeg() {
            return windDeg;
        }

        public void setWindDeg(String windDeg) {
            this.windDeg = windDeg;
        }

        public String getWindDir() {
            return windDir;
        }

        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }

        public String getWindSc() {
            return windSc;
        }

        public void setWindSc(String windSc) {
            this.windSc = windSc;
        }

        public String getWindSpd() {
            return windSpd;
        }

        public void setWindSpd(String windSpd) {
            this.windSpd = windSpd;
        }

        @Override
        public String toString() {
            return "NowEntity{" +
                    "cloud='" + cloud + '\'' +
                    ", condCode='" + condCode + '\'' +
                    ", condTxt='" + condTxt + '\'' +
                    ", fl='" + fl + '\'' +
                    ", hum='" + hum + '\'' +
                    ", pcpn='" + pcpn + '\'' +
                    ", pres='" + pres + '\'' +
                    ", tmp='" + tmp + '\'' +
                    ", vis='" + vis + '\'' +
                    ", windDeg='" + windDeg + '\'' +
                    ", windDir='" + windDir + '\'' +
                    ", windSc='" + windSc + '\'' +
                    ", windSpd='" + windSpd + '\'' +
                    '}';
        }
    }

    public static class LifestyleEntity implements Serializable {

        /**
         * type : cw
         * brf : 较适宜
         * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
         */
        /**
         * type : drsg
         * brf : 较冷
         * txt : 建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。
         */
        /**
         * type : flu
         * brf : 较易发
         * txt : 昼夜温差较大，较易发生感冒，请适当增减衣服。体质较弱的朋友请注意防护。
         */
        /**
         * type : sport
         * brf : 较适宜
         * txt : 阴天，较适宜进行各种户内外运动。
         */
        /**
         * type : trav
         * brf : 适宜
         * txt : 天气较好，温度适宜，总体来说还是好天气哦，这样的天气适宜旅游，您可以尽情地享受大自然的风光。
         */
        /**
         * type : uv
         * brf : 最弱
         * txt : 属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。
         */

        /**
         * type : comf
         * brf : 较舒适
         * txt : 白天天气阴沉，会感到有点儿凉，但大部分人完全可以接受。
         */
        @SerializedName("type")
        private String type;
        @SerializedName("brf")
        private String brf;
        @SerializedName("txt")
        private String txt;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getBrf() {
            return brf;
        }

        public void setBrf(String brf) {
            this.brf = brf;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        @Override
        public String toString() {
            return "LifestyleEntity{" +
                    "type='" + type + '\'' +
                    ", brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    public static class DailyForecastEntity implements Serializable {
        /**
         "cond_code_d":"302",
         "cond_code_n":"302",
         "cond_txt_d":"雷阵雨",
         "cond_txt_n":"雷阵雨",
         "date":"2018-06-25",
         "hum":"34",
         "mr":"17:02",
         "ms":"02:49",
         "pcpn":"0.0",
         "pop":"6",
         "pres":"1004",
         "sr":"04:47",
         "ss":"19:48",
         "tmp_max":"34",
         "tmp_min":"24",
         "uv_index":"5",
         "vis":"20",
         "wind_deg":"126",
         "wind_dir":"东南风",
         "wind_sc":"1-2",
         "wind_spd":"2"
         */

        @SerializedName("sr")
        private String sr;
        @SerializedName("ss")
        private String ss;
        @SerializedName("mr")
        private String mr;
        @SerializedName("ms")
        private String ms;
        @SerializedName("cond_code_d")
        private String condCodeD;
        @SerializedName("cond_code_n")
        private String condCodeN;
        @SerializedName("cond_txt_d")
        private String condTxtD;
        @SerializedName("cond_txt_n")
        private String condTxtN;
        @SerializedName("date")
        private String date;
        @SerializedName("hum")
        private String hum;
        @SerializedName("pcpn")
        private String pcpn;
        @SerializedName("pop")
        private String pop;
        @SerializedName("pres")
        private String pres;
        @SerializedName("tmp_max")
        private String tmpMax;
        @SerializedName("tmp_min")
        private String tmpMin;
        @SerializedName("vis")
        private String vis;
        @SerializedName("wind_deg")
        private String windDeg;
        @SerializedName("wind_dir")
        private String windDir;
        @SerializedName("wind_sc")
        private String windSc;
        @SerializedName("wind_spd")
        private String windSpd;

        public String getSr() {
            return sr;
        }

        public void setSr(String sr) {
            this.sr = sr;
        }

        public String getSs() {
            return ss;
        }

        public void setSs(String ss) {
            this.ss = ss;
        }

        public String getMr() {
            return mr;
        }

        public void setMr(String mr) {
            this.mr = mr;
        }

        public String getMs() {
            return ms;
        }

        public void setMs(String ms) {
            this.ms = ms;
        }

        public String getCondCodeD() {
            return condCodeD;
        }

        public void setCondCodeD(String condCodeD) {
            this.condCodeD = condCodeD;
        }

        public String getCondCodeN() {
            return condCodeN;
        }

        public void setCondCodeN(String condCodeN) {
            this.condCodeN = condCodeN;
        }

        public String getCondTxtD() {
            return condTxtD;
        }

        public void setCondTxtD(String condTxtD) {
            this.condTxtD = condTxtD;
        }

        public String getCondTxtN() {
            return condTxtN;
        }

        public void setCondTxtN(String condTxtN) {
            this.condTxtN = condTxtN;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getPcpn() {
            return pcpn;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public String getPop() {
            return pop;
        }

        public void setPop(String pop) {
            this.pop = pop;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public String getTmpMax() {
            return tmpMax;
        }

        public void setTmpMax(String tmpMax) {
            this.tmpMax = tmpMax;
        }

        public String getTmpMin() {
            return tmpMin;
        }

        public void setTmpMin(String tmpMin) {
            this.tmpMin = tmpMin;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public String getWindDeg() {
            return windDeg;
        }

        public void setWindDeg(String windDeg) {
            this.windDeg = windDeg;
        }

        public String getWindDir() {
            return windDir;
        }

        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }

        public String getWindSc() {
            return windSc;
        }

        public void setWindSc(String windSc) {
            this.windSc = windSc;
        }

        public String getWindSpd() {
            return windSpd;
        }

        public void setWindSpd(String windSpd) {
            this.windSpd = windSpd;
        }

        @Override
        public String toString() {
            return "DailyForecastEntity{" +
                    "sr='" + sr + '\'' +
                    ", ss='" + ss + '\'' +
                    ", mr='" + mr + '\'' +
                    ", ms='" + ms + '\'' +
                    ", condCodeD='" + condCodeD + '\'' +
                    ", condCodeN='" + condCodeN + '\'' +
                    ", condTxtD='" + condTxtD + '\'' +
                    ", condTxtN='" + condTxtN + '\'' +
                    ", date='" + date + '\'' +
                    ", hum='" + hum + '\'' +
                    ", pcpn='" + pcpn + '\'' +
                    ", pop='" + pop + '\'' +
                    ", pres='" + pres + '\'' +
                    ", tmpMax='" + tmpMax + '\'' +
                    ", tmpMin='" + tmpMin + '\'' +
                    ", vis='" + vis + '\'' +
                    ", windDeg='" + windDeg + '\'' +
                    ", windDir='" + windDir + '\'' +
                    ", windSc='" + windSc + '\'' +
                    ", windSpd='" + windSpd + '\'' +
                    '}';
        }
    }

    public BasicEntity getBasic() {
        return basic;
    }

    public void setBasic(BasicEntity basic) {
        this.basic = basic;
    }

    public UpdateEntity getUpdate() {
        return update;
    }

    public void setUpdate(UpdateEntity update) {
        this.update = update;
    }

    public NowEntity getNow() {
        return now;
    }

    public void setNow(NowEntity now) {
        this.now = now;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<LifestyleEntity> getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(List<LifestyleEntity> suggestion) {
        this.suggestion = suggestion;
    }

    public List<DailyForecastEntity> getDailyForecast() {
        return dailyForecast;
    }

    public void setDailyForecast(List<DailyForecastEntity> dailyForecast) {
        this.dailyForecast = dailyForecast;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "basic=" + basic +
                ", update=" + update +
                ", now=" + now +
                ", status='" + status + '\'' +
                ", suggestion=" + suggestion +
                ", dailyForecast=" + dailyForecast +
                '}';
    }
}
