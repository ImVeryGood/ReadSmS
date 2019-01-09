package com.example.administrator.mr.readsms.feature.ui;


import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.example.administrator.mr.readsms.R;
import com.example.administrator.mr.readsms.feature.bean.BannerBean;
import com.example.administrator.mr.readsms.feature.presenter.BannerPresenter;
import com.example.administrator.mr.readsms.feature.view.BannerView;
import com.example.administrator.mr.readsms.project.mvp.base.BaseFragment;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public  class BannerFragment extends BaseFragment<BannerPresenter> implements BannerView {


    @BindView(R.id.image)
    ImageView image;

    public BannerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreateView() {
        presenter.bannerData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_banner;
    }

    @Override
    public BannerPresenter initPresenter() {
        return new BannerPresenter(this);
    }

    @Override
    public void showBanner(BannerBean bannerBean) {
        Picasso.with(getActivity())
                .load(bannerBean.getData().get((int) (Math.random() * 3))
                        .getImagePath()).into(image);
    }

    @Override
    public void showProgress(long totalSize, long downSize) {

    }

    @Override
    public void downSuccess(String path) {

    }

}
