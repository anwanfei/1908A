package com.anfly.mvp.model;

import com.anfly.mvp.api.ApiService;
import com.anfly.mvp.base.BaseModel;
import com.anfly.mvp.base.BaseObserver;
import com.anfly.mvp.bean.LoginBean;
import com.anfly.mvp.callback.LoginCallback;
import com.anfly.mvp.utils.HttpManager;
import com.anfly.mvp.utils.RxUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpLoginModel extends BaseModel implements LoginModel {

    @Override
    public void login(String name, String pwd, LoginCallback loginCallback) {
        HttpManager.getHttpManager().getApiService(ApiService.baseLoginUrl, ApiService.class)
                .login(name, pwd)
                .compose(RxUtil.rxObservableTransformer())
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    public void onSuccess(LoginBean loginBean) {
                        int errorCode = loginBean.getErrorCode();
                        if (errorCode == 0) {
                            loginCallback.onSuccess(loginBean);
                        } else {
                            loginCallback.onFail(loginBean.getErrorMsg());
                        }
                    }

                    @Override
                    public void onFail(String error) {
                        loginCallback.onFail(error);
                    }
                });
    }
}
