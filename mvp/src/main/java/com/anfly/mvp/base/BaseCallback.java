package com.anfly.mvp.base;

public interface BaseCallback<T> {
    void onSuccess(T t);

    void onFail(String error);
}
