package com.anfly.mvptest.base;

public interface BaseView<T> {
    void onSucess(T t);

    void onFail(String error);
}
