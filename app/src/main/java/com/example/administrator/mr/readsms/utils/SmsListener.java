package com.example.administrator.mr.readsms.utils;

import java.util.List;
import java.util.Map;

public interface SmsListener {
    void successSms(List<Map<String, Object>> mapList);

    void errorSms(String error);
}
