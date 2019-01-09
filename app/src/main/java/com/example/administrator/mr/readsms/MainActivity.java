package com.example.administrator.mr.readsms;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.mr.readsms.feature.bean.BannerBean;
import com.example.administrator.mr.readsms.feature.bean.SmsBean;
import com.example.administrator.mr.readsms.feature.ui.BannerActivity;
import com.example.administrator.mr.readsms.project.net.ApiManager;
import com.example.administrator.mr.readsms.project.net.MObserver;
import com.example.administrator.mr.readsms.premission.RxPremissionActivity;
import com.example.administrator.mr.readsms.project.service.WeatherService;
import com.example.administrator.mr.readsms.utils.JumpUtils;
import com.google.gson.Gson;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends RxAppCompatActivity {
    private Uri SMS_INBOX = Uri.parse("content://sms/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Rx();
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PhoneInfoUtils.getSMSLog(MainActivity.this, new SmsListener() {
//                    @Override
//                    public void successSms(List<Map<String, Object>> mapList) {
//                        Log.d("SSSSSSSSSSs", "successSms: " + new Gson().toJson(mapList));
//                        Toast.makeText(MainActivity.this, new Gson().toJson(mapList), Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void errorSms(String error) {
//                        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
//                    }
//                });
                getData();
            }
        });
    }


    /**
     * 短信记录获取
     *
     * @param
     * @param
     */

    public void getSMSLog() {
        Observable.just(getContentResolver()).map(new Function<ContentResolver, List<SmsBean>>() {
            @Override
            public List<SmsBean> apply(ContentResolver contentResolver) throws Exception {
                return null;
            }
        }).flatMap(new Function<List<SmsBean>, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(List<SmsBean> smsBeans) throws Exception {
                String body = null;
                for (SmsBean smsBean : smsBeans) {
                    body = smsBean.getBody();
                }
                return Observable.just(body);
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                Log.d("SSSS", "onNext: value=" + value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    public void apiUpLoadSms() {
        /**
         * map 将被观察发送的事件转换为任意类型的事件
         * flatMap :将被观察者发送的事件序列进行拆分&单独转换，再合并成为一个新的
         * 事件序列，最好再发送
         */
        Observable.just(getContentResolver())
                .map(new Function<ContentResolver, List<SmsBean>>() {
                    @Override
                    public List<SmsBean> apply(ContentResolver contentResolver) throws Exception {
                        Map<String, Object> map = new HashMap<String, Object>();
                        List<SmsBean> smsBeanList = new ArrayList<>();
                        String[] projection = new String[]{"_id", "address", "person", "body", "date", "type"};
                        try {
                            Uri smsUri = Uri.parse("content://sms/");
                            // 通过Cursor获得数据
                            Cursor cursor = getContentResolver().query(smsUri, projection, null, null, "date desc");
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    String smsType = cursor.getString(cursor.getColumnIndex("type"));
                                    int type = Integer.parseInt(smsType);
                                    if (type == 1) {
                                        smsType = "receive";//收到
                                    } else if (type == 2) {
                                        smsType = "send";//发出
                                    } else {
                                        smsType = "other";//失败等
                                    }
                                    String smsNumber = cursor.getString(cursor.getColumnIndex("address"));
                                    String smsBody = cursor.getString(cursor.getColumnIndex("body"));
                                    String smsDate = cursor.getString(cursor.getColumnIndex("date"));
                                    SmsBean smsBean = new SmsBean();
                                    smsBean.setBody(smsBody);
                                    smsBean.setDate(smsDate);
                                    smsBean.setNumber(smsNumber);
                                    smsBean.setType(smsType);
                                    smsBeanList.add(smsBean);
                                }
                                cursor.close();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                        return smsBeanList;
                    }
                }).subscribe(new Observer<List<SmsBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<SmsBean> value) {
                Log.d("SSSSSSSSSSS", "onNext: " + new Gson().toJson(value));
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * retrofit
     */
    public void retrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(WeatherService.class).getMessage("").enqueue(new Callback<SmsBean>() {
            @Override
            public void onResponse(Call<SmsBean> call, Response<SmsBean> response) {

            }

            @Override
            public void onFailure(Call<SmsBean> call, Throwable t) {

            }
        });

    }

    public void rxRetro() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        final WeatherService weatherService = retrofit.create(WeatherService.class);
        weatherService.getRxMessage("")
                .flatMap(new Function<SmsBean, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(SmsBean smsBean) throws Exception {
                        return Observable.just(smsBean.getBody());
                    }
                }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void Rx() {
        int a[] = {1, 2, 3, 4, 5, 6};
        Observable.just(a).map(new Function<int[], Integer>() {
            @Override
            public Integer apply(int[] ints) throws Exception {
                int item = 0;
                for (int anInt : ints) {
                    item = anInt;
                }
                return item;
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                return Observable.just(integer + "处理了");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {
                Log.d("SSSSSSSSSS", "onNext: " + value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void request(View view) {
        startActivity(new Intent(this, RxPremissionActivity.class));
    }

    public void getData() {
        ApiManager.getInstance().bannerData()
                .compose(ApiManager.<BannerBean>toMainThread())
                .compose(this.<BannerBean>bindToLifecycle())
                .subscribe(new MObserver<BannerBean>(null) {
                    @Override
                    protected void success(BannerBean bannerBean) {
                        // Log.d("SSSSs", "success: " + new Gson().toJson(bannerBean));B
                    }

                    @Override
                    protected void error(String error) {
                        Log.d("SSSSs", "error: " + error);
                    }
                });
    }


    public void goToMvp(View view) {
        JumpUtils.jump2Target(this, BannerActivity.class);
    }


}
