package com.example.administrator.mr.readsms.feature.ui;


import android.Manifest;
import android.annotation.SuppressLint;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.administrator.mr.readsms.R;
import com.example.administrator.mr.readsms.feature.bean.BannerBean;
import com.example.administrator.mr.readsms.feature.presenter.BannerPresenter;
import com.example.administrator.mr.readsms.feature.view.BannerView;
import com.example.administrator.mr.readsms.project.downfile.DownModel;
import com.example.administrator.mr.readsms.project.downfile.FileUtil;
import com.example.administrator.mr.readsms.project.mvp.base.BaseActivity;
import com.squareup.picasso.Picasso;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;



public class BannerActivity extends BaseActivity<BannerPresenter> implements BannerView {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.frame_container)
    FrameLayout frameContainer;
    protected BannerFragment bannerFragment;
    @BindView(R.id.test)
    Button test;
    private FragmentTransaction transaction;
    private String mPath;

    @Override
    public int getLayoutId() {
        return R.layout.activity_banner;
    }

    @Override
    public void onCreate() {
        checkPremission();
        initFragment();
    }

    @Override
    public BannerPresenter initPresenter() {
        return new BannerPresenter(this);
    }

    @Override
    public void showBanner(BannerBean bannerBean) {
        Picasso.with(this).load(bannerBean.getData()
                .get((int) (Math.random() * 3))
                .getImagePath()).into(image);
    }

    @Override
    public void showProgress(DownModel downModel) {
        int progress = (int) (downModel.getDownSize() * 100 / downModel.getTotalSize());
        test.setText(progress + "%");
    }

    @Override
    public void downSuccess(String path) {
        mPath = path;
    }

    public void initFragment() {
        bannerFragment = new BannerFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_container, bannerFragment)
                .commit();
    }

    @OnClick({R.id.data, R.id.test, R.id.delete, R.id.up_load})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.data:
                presenter.bannerData();
                break;
            case R.id.test:
                presenter.downFile();
                break;
            case R.id.delete:
                FileUtil.delete(mPath);
                break;
            case R.id.up_load:
                presenter.upLoad(mPath);
                break;
        }
    }

    @SuppressLint("CheckResult")
    public void checkPremission() {
        new RxPermissions(this).requestEach(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {

                    }
                });
    }
}
