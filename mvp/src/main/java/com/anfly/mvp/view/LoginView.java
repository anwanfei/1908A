package com.anfly.mvp.view;

import com.anfly.mvp.base.BaseView;
import com.anfly.mvp.bean.LoginBean;

public interface LoginView extends BaseView<LoginBean> {
    @Override
    void onSuccess(LoginBean loginBean);

    @Override
    void onFail(String error);
}
