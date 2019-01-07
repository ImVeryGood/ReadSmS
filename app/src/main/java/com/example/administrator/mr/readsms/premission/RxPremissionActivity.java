package com.example.administrator.mr.readsms.premission;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.mr.readsms.R;
import com.jakewharton.rxbinding2.view.RxView;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

public class RxPremissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_premission);
        requestPre();
    }

    @SuppressLint("CheckResult")
    public void requestPre() {
        RxView.clicks(findViewById(R.id.request))
                .throttleFirst(2, TimeUnit.SECONDS)
                .debounce(1, TimeUnit.SECONDS)
                .compose(new RxPermissions(this)
                        .ensure(Manifest.permission.CALL_PHONE))
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Toast.makeText(RxPremissionActivity.this, "数据=" + aBoolean, Toast.LENGTH_SHORT).show();
                    }
                });

        new RxPermissions(this)
                .requestEach(Manifest.permission.CALL_PHONE)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {

                    }
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("CheckResult")
    public void premsissions() {
        /**
         * 权限申请
         */
        new RxPermissions(RxPremissionActivity.this).requestEach(
                Manifest.permission.READ_CALL_LOG).subscribe(new Consumer<Permission>() {
            @Override
            public void accept(Permission permission) throws Exception {
                if (permission.granted) {
                    Toast.makeText(RxPremissionActivity.this, "同意", Toast.LENGTH_SHORT).show();
                } else if (permission.shouldShowRequestPermissionRationale) {
                    Toast.makeText(RxPremissionActivity.this, "用户拒绝了，但是没有点击拒绝下次询问", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RxPremissionActivity.this, "不在询问", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
