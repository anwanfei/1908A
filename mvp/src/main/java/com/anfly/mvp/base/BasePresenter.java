package com.anfly.mvp.base;

public abstract class BasePresenter<V extends BaseView> {
    protected V mView;

    public void setmView(V mView) {
        this.mView = mView;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
