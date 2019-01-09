package com.example.administrator.mr.readsms.project.service;

import com.example.administrator.mr.readsms.feature.bean.SmsBean;
import com.example.administrator.mr.readsms.feature.bean.BannerBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface WeatherService {
    //  网络接口的使用为查询天气的接口
    @GET("weather_mini")
    Call<SmsBean> getMessage(@Query("city") String city);

    @GET("weather_mini")
    Observable<SmsBean> getRxMessage(@Query("city") String city);

    @GET("/banner/json")
    Observable<BannerBean> bannerData();

    @Streaming//大文件要加不然会oom
    @GET
    Observable<ResponseBody> dowmLoadFile(@Url String fileUrl);
}
