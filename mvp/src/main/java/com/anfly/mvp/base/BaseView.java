package com.anfly.mvp.base;

public interface BaseView<T> {
    void onSuccess(T t);

    void onFail(String error);
}
