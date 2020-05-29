package com.anfly.mvp.view;

import com.anfly.mvp.bean.LoginBean;

public interface LoginView {
    void onSuccess(LoginBean loginBean);

    void onFail(String error);
}
