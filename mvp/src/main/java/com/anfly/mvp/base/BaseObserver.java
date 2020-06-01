package com.anfly.mvp.base;


import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
        // TODO: 2020/6/1
        Log.e("TAG", "订阅成功");
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        onFail("net error:" + e.getMessage());
    }

    @Override
    public void onComplete() {
        Log.e("TAG", "onComplete()");
    }

    public abstract void onSuccess(T t);

    public abstract void onFail(String error);
}
