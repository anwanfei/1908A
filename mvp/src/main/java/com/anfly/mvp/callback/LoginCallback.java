package com.anfly.mvp.callback;

import com.anfly.mvp.base.BaseCallback;
import com.anfly.mvp.bean.LoginBean;

public interface LoginCallback extends BaseCallback<LoginBean> {
    @Override
    void onSuccess(LoginBean loginBean);

    @Override
    void onFail(String error);
}
