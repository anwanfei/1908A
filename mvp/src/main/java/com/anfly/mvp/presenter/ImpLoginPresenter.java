package com.anfly.mvp.presenter;

import android.text.TextUtils;
import android.widget.Toast;

import com.anfly.mvp.base.BasePresenter;
import com.anfly.mvp.bean.LoginBean;
import com.anfly.mvp.callback.LoginCallback;
import com.anfly.mvp.model.ImpLoginModel;
import com.anfly.mvp.view.LoginView;

public class ImpLoginPresenter extends BasePresenter implements LoginPresenter, LoginCallback {

    private ImpLoginModel model;


    @Override
    public void login(String name, String pwd) {
        if (TextUtils.isEmpty(name)) {
            mView.onFail("name不能为空");
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            mView.onFail("pwd不能为空");
            return;
        }

        model.login(name, pwd, this);
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        mView.onSuccess(loginBean);
    }

    @Override
    public void onFail(String error) {
        mView.onFail(error);
    }

    @Override
    protected void initModel() {
        model = new ImpLoginModel();
    }
}
