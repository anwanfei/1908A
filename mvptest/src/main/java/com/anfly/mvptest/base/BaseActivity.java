package com.anfly.mvptest.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter, V extends BaseView> extends AppCompatActivity {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.setmView(initMvpView());
        }
        initView();//有些子类需要，有些不需要
        initData();//有些子类需要，有些不需要，仅仅用普通方法即可
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract V initMvpView();

    protected abstract P initPresenter();

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestory();
        mPresenter = null;
    }
}
