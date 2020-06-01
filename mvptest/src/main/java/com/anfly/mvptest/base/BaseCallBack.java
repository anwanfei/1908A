package com.anfly.mvptest.base;

public interface BaseCallBack<T> {
    void onSucess(T t);

    void onFail(String error);
}
