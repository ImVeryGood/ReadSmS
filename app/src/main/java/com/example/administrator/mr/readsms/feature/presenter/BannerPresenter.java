package com.example.administrator.mr.readsms.feature.presenter;

import android.util.Log;

import com.example.administrator.mr.readsms.feature.bean.BannerBean;
import com.example.administrator.mr.readsms.feature.view.BannerView;
import com.example.administrator.mr.readsms.project.downfile.DownFileCallback;
import com.example.administrator.mr.readsms.project.downfile.DownLoadManager;
import com.example.administrator.mr.readsms.project.downfile.DownModel;
import com.example.administrator.mr.readsms.project.downfile.FileUtil;
import com.example.administrator.mr.readsms.project.mvp.base.BasePresenter;
import com.example.administrator.mr.readsms.project.net.ApiManager;
import com.example.administrator.mr.readsms.project.net.MObserver;
import com.example.administrator.mr.readsms.utils.ApkUtil;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

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

    /**
     * 下载文件
     */
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

    /**
     * 上传文件
     *
     * @param path 文件路径
     */
    public void upLoad(String path) {
        File file = new File(path);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("uploadFile", file.getName(), requestBody);
        ApiManager.getInstance().upload(part)
                .compose(ApiManager.<String>toMainThread())
                .subscribe(new MObserver<String>(dialog) {
                    @Override
                    protected void success(String s) {
                        Log.d("SSSSSSSSSS", "success: " + s);
                    }

                    @Override
                    protected void error(String error) {
                        Log.d("SSSSSS", "error: " + error);
                    }
                });
    }


}
