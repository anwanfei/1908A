package com.anfly.mvp.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anfly.mvp.common.MvpApplication;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter, V extends BaseView> extends AppCompatActivity {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        mPresenter = initMvpPresenter();
        if (mPresenter != null) {
            mPresenter.setmView(initMvpView());
        }

        initView();
        initData();
        initListener();
    }

    protected abstract V initMvpView();

    protected abstract P initMvpPresenter();

    private void initListener() {

    }

    private void initData() {

    }

    private void initView() {

    }

    protected abstract int getLayoutId();

    public void toast(String msg) {
        Toast.makeText(MvpApplication.getApp(), msg, Toast.LENGTH_SHORT).show();
    }
}
