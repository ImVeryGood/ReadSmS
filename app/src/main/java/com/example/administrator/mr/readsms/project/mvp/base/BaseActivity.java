package com.example.administrator.mr.readsms.project.mvp.base;

import android.content.Context;
import android.os.Bundle;

import com.example.administrator.mr.readsms.utils.FitStateUI;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter> extends RxAppCompatActivity implements BaseView {
    protected P presenter;
    public Context mContext;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mContext = this;
        presenter = initPresenter();
        FitStateUI.setImmersionStateMode(this);
        unbinder = ButterKnife.bind(this);
        onCreate();
    }

    /**
     * @return 布局id
     */
    public abstract int getLayoutId();

    /**
     * onCreate 方法
     */
    public abstract void onCreate();

    @Override
    public Context mContext() {
        return mContext;
    }

    public abstract P initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (presenter != null) {
            presenter.detach();
        }

    }
}
