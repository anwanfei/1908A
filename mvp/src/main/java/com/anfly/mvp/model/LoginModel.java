package com.anfly.mvp.model;

import com.anfly.mvp.bean.LoginBean;
import com.anfly.mvp.callback.LoginCallback;

public interface LoginModel {
    void login(String name, String pwd, LoginCallback loginCallback);
}
