package com.anfly.mvp.callback;

import com.anfly.mvp.bean.LoginBean;

public interface LoginCallback {
    void onSuccess(LoginBean loginBean);

    void onFail(String error);
}
