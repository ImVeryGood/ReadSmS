package com.example.administrator.mr.readsms.feature.ui;


;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.administrator.mr.readsms.R;
import com.example.administrator.mr.readsms.feature.bean.BannerBean;
import com.example.administrator.mr.readsms.feature.presenter.BannerPresenter;
import com.example.administrator.mr.readsms.feature.view.BannerView;
import com.example.administrator.mr.readsms.project.mvp.base.BaseActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.OnClick;

public class BannerActivity extends BaseActivity<BannerPresenter> implements BannerView {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.frame_container)
    FrameLayout frameContainer;
    protected BannerFragment bannerFragment;
    private FragmentTransaction transaction;

    @Override
    public int getLayoutId() {
        return R.layout.activity_banner;
    }

    @Override
    public void onCreate() {
        initFragment();
    }

    @Override
    public BannerPresenter initPresenter() {
        return new BannerPresenter(this);
    }

    @Override
    public void showBanner(BannerBean bannerBean) {
        Picasso.with(this).load(bannerBean.getData().get((int) (Math.random()*3)).getImagePath()).into(image);
    }

    public void initFragment() {
        bannerFragment = new BannerFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_container, bannerFragment)
                .commit();

    }

    @OnClick({R.id.data, R.id.test})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.data:
                presenter.bannerData();
                break;
            case R.id.test:
                initFragment();
                break;
        }
    }

}
