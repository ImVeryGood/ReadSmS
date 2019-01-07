package com.example.administrator.mr.readsms.feature.presenter;

import com.example.administrator.mr.readsms.feature.bean.BannerBean;
import com.example.administrator.mr.readsms.feature.view.BannerView;
import com.example.administrator.mr.readsms.project.mvp.base.BasePresenter;
import com.example.administrator.mr.readsms.project.net.ApiManager;
import com.example.administrator.mr.readsms.project.net.MObserver;

/**
 * date:2019/1/4
 */
public class BannerPresenter extends BasePresenter<BannerView> {
    public BannerPresenter(BannerView view) {
        super(view);
    }

    @Override
    protected void init() {

    }

    public void bannerData() {

        ApiManager.getInstance().bannerData()
                .compose(ApiManager.<BannerBean>toMainThread())
                .compose(view.<BannerBean>bindToLifecycle())
                .subscribe(new MObserver<BannerBean>(dialog) {
                    @Override
                    protected void success(BannerBean bannerBean) {
                        view.showBanner(bannerBean);
                    }

                    @Override
                    protected void error(String error) {


                    }
                });
    }

}
