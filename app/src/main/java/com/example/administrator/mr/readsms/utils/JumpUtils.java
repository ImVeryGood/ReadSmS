package com.example.administrator.mr.readsms.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * date:2019/1/7
 */
public class JumpUtils {
    /**
     * 跳转到指定activity
     * 无值传递
     *
     * @param mContext       当前activity
     * @param targetActivity 目标activity
     */
    public static void jump2Target(Activity mContext, Class<?> targetActivity) {
        mContext.startActivity(new Intent(mContext, targetActivity));
    }

    /**
     * 页面跳转 bundle 传值
     *
     * @param activity
     * @param targetActivity
     * @param bundle
     */
    public static void jump2Activity(Activity activity, Class<?> targetActivity, Bundle bundle) {
        Intent intent = new Intent(activity, targetActivity);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }


}
