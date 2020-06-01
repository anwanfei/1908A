package com.anfly.mvptest.presenter;

import com.anfly.mvptest.base.BaseCallBack;
import com.anfly.mvptest.base.BasePresenter;
import com.anfly.mvptest.base.BaseView;
import com.anfly.mvptest.bean.LoginBean;
import com.anfly.mvptest.model.LoginModel;

public class LoginPresenter extends BasePresenter<BaseView<LoginBean>> implements BaseCallBack<LoginBean> {

    private LoginModel loginModel;

    @Override
    protected void initMdel() {
        loginModel = new LoginModel();
        addModel(loginModel);
    }

    public void login(String name, String pwd) {
        loginModel.login(name, pwd, this);
    }

    @Override
    public void onSucess(LoginBean loginBean) {
        mView.onSucess(loginBean);
    }

    @Override
    public void onFail(String error) {
        mView.onFail(error);
    }
}
