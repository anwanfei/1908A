package com.anfly.mvptest.model;

import com.anfly.mvptest.api.ApiService;
import com.anfly.mvptest.base.BaseCallBack;
import com.anfly.mvptest.base.BaseModel;
import com.anfly.mvptest.base.BaseObserver;
import com.anfly.mvptest.bean.LoginBean;
import com.anfly.mvptest.utils.HttpManager;
import com.anfly.mvptest.utils.RxUtil;

public class LoginModel extends BaseModel {
    public void login(String name, String pwd, final BaseCallBack<LoginBean> callBack) {
        HttpManager.getHttpManager().getApiService(ApiService.baseLoginUrl, ApiService.class)
                .login(name, pwd)
                .compose(RxUtil.<LoginBean>rxTransform())
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    public void onSucess(LoginBean loginBean) {
                        if (loginBean.getErrorCode() == 0) {
                            callBack.onSucess(loginBean);
                        } else {
                            callBack.onFail(loginBean.getErrorMsg());
                        }
                    }

                    @Override
                    public void onFail(String error) {
                        callBack.onFail(error);
                    }
                });
    }
}
