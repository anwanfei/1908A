package com.anfly.mvp.presenter;

import android.text.TextUtils;
import android.widget.Toast;

import com.anfly.mvp.bean.LoginBean;
import com.anfly.mvp.callback.LoginCallback;
import com.anfly.mvp.model.ImpLoginModel;
import com.anfly.mvp.view.LoginView;

public class ImpLoginPresenter implements LoginPresenter, LoginCallback {
    private ImpLoginModel model;
    private LoginView view;

    public ImpLoginPresenter(LoginView view) {
        this.view = view;
        model = new ImpLoginModel();
    }

    @Override
    public void login(String name, String pwd) {
        if (TextUtils.isEmpty(name)) {
            view.onFail("name不能为空");
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            view.onFail("pwd不能为空");
            return;
        }

        model.login(name, pwd, this);
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        view.onSuccess(loginBean);
    }

    @Override
    public void onFail(String error) {
        view.onFail(error);
    }
}
