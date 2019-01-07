package com.example.administrator.mr.readsms.utils;

import android.Manifest;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PhoneInfoUtils {

    /**
     * 短信记录获取
     *
     * @param
     * @param
     */

    public static void getSMSLog(Context mContext, SmsListener smsListener) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (!CheckPermssion.selfPermissionGranted(mContext, Manifest.permission.READ_SMS)) {
            smsListener.errorSms("没有读取权限");
            return;
        }
        Map<String, Object> map = new HashMap<>();
        String[] projection = new String[]{"_id", "address", "person", "body", "date", "type"};
        try {
            Uri smsUri = Uri.parse("content://sms/");
            // 通过Cursor获得数据
            Cursor cursor = mContext.getContentResolver().query(smsUri, projection, null, null, "date desc");
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
                    map.put("type", smsType);
                    map.put("number", smsNumber);
                    map.put("body", smsBody);
                    map.put("date", smsDate);
                    mapList.add(map);

                }
                cursor.close();
            }
            smsListener.successSms(mapList);
        } catch (Exception e) {
            e.printStackTrace();
            smsListener.errorSms(e.getMessage());
        }

    }

}
