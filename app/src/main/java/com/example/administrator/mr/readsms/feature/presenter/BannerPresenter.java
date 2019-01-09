package com.example.administrator.mr.readsms.feature.presenter;

import android.util.Log;

import com.example.administrator.mr.readsms.feature.bean.BannerBean;
import com.example.administrator.mr.readsms.feature.view.BannerView;
import com.example.administrator.mr.readsms.project.downfile.DownFileCallback;
import com.example.administrator.mr.readsms.project.downfile.DownLoadManager;
import com.example.administrator.mr.readsms.project.downfile.DownModel;
import com.example.administrator.mr.readsms.project.mvp.base.BasePresenter;
import com.example.administrator.mr.readsms.project.net.ApiManager;
import com.example.administrator.mr.readsms.project.net.MObserver;
import com.example.administrator.mr.readsms.utils.ApkUtil;

/**
 * date:2019/1/4
 */
public class BannerPresenter extends BasePresenter<BannerView> {
    DownModel downModel;

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

    public void downFile() {
        String url = ApkUtil.apkUrl;
        if (downModel == null) {
            downModel = new DownModel();
            downModel.setUrl(url);
        }
        DownLoadManager.getInstance().downFile(downModel, new DownFileCallback() {
            @Override
            public void onSuccess(String path) {
                Log.d("SSSSSSSSS", "onSuccess: " + path);
                view.downSuccess(path);
            }

            @Override
            public void onFail(String msg) {

            }

            @Override
            public void onProgress(long totalSize, long downSize) {
                Log.d("SSSSSSSSS", "onProgress: downSize==" + downSize);
                if (downModel.getTotalSize() == 0) {
                    downModel.setTotalSize(totalSize);
                }
                downModel.setCurrentTotalSize(totalSize);

                downModel.setDownSize(downSize + downModel.getTotalSize() - downModel.getCurrentTotalSize());
                view.showProgress(downModel);
            }
        });
    }
}
