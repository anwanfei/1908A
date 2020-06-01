package com.anfly.mvptest.base;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
        Log.e("TAG", "");
    }

    @Override
    public void onNext(T t) {
        onSucess(t);
    }

    @Override
    public void onError(Throwable e) {
        onFail("网络错误：" + e.getMessage());
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSucess(T t);

    public abstract void onFail(String error);
}
