package com.example.administrator.mr.readsms.app;

import android.content.Context;

import com.orhanobut.logger.AndroidLogTool;
import com.orhanobut.logger.Logger;


/**
 * date:2019/1/2
 */
public class MApp extends android.app.Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Logger
                .init("ReadSms")
                .hideThreadInfo()
                .logTool(new AndroidLogTool());
    }

    public static Context getContext() {
        return mContext;
    }
}
