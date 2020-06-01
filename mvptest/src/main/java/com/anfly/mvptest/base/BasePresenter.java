package com.anfly.mvptest.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
    protected V mView;
    private ArrayList<BaseModel> mModels = new ArrayList<>();

    public BasePresenter() {
        initMdel();
    }

    protected abstract void initMdel();

    public void setmView(V mView) {
        this.mView = mView;
    }

    public void onDestory() {
        //打断P层和V层的联系,
        mView = null;
        //掐断网络请求
        if (mModels.size() > 0) {
            for (BaseModel model : mModels) {
                model.onDestory();
            }
            mModels.clear();
        }
    }

    public void addModel(BaseModel model) {
        mModels.add(model);
    }
}
