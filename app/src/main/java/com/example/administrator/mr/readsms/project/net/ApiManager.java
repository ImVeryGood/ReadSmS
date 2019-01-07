package com.example.administrator.mr.readsms.project.net;

import com.example.administrator.mr.readsms.project.service.WeatherService;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2019/1/2
 */
public class ApiManager {
    protected static String BASE_URL = "http://www.wanandroid.com";

    public static WeatherService getInstance() {
        return HolderClass.service;
    }

    private static class HolderClass {
        private static WeatherService service = ReManager.getInstance().create(WeatherService.class);
    }

    /**
     * 处理code
     *
     * @param <T>
     * @return
     */
    public static  <T> ObservableTransformer<BaseBean<T>, T> filterData() {
        return new ObservableTransformer<BaseBean<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseBean<T>> upstream) {
                return upstream
                        .filter(new Predicate<BaseBean<T>>() {
                            @Override
                            public boolean test(BaseBean<T> bean) throws Exception {
                                if (bean.getCode().equals("200") && bean.isSuccess()) {
                                    if (null != bean.getResult()) {
                                        return true;
                                    } else {
                                        throw new ApiException("暂无数据");
                                    }
                                } else {
                                    throw new ApiException(bean.getMsg());
                                }
                            }
                        })
                        .map(new Function<BaseBean<T>, T>() {
                            @Override
                            public T apply(BaseBean<T> tBaseBean) throws Exception {
                                return tBaseBean.getResult();
                            }
                        });
            }
        };
    }

    /**
     * rx切换到主线程
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> toMainThread() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
