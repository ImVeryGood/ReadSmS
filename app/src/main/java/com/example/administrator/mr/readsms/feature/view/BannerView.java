package com.example.administrator.mr.readsms.feature.view;

import com.example.administrator.mr.readsms.feature.bean.BannerBean;
import com.example.administrator.mr.readsms.project.mvp.base.BaseView;

/**
 * date:2019/1/4
 */
public interface BannerView extends BaseView {

    void showBanner(BannerBean bannerBean);

    void showProgress(long totalSize, long downSize);

    void downSuccess(String path);
}
