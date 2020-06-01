package com.anfly.mvp.base;


import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {

    private Disposable mDisposable;
    private BaseModel mModel;

    public BaseObserver(BaseModel mModel) {
        this.mModel = mModel;
    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
        mModel.addModel(mDisposable);
        Log.e("TAG", "订阅成功");
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
        mDisposable.dispose();
        mModel.compositeDisposable.remove(mDisposable);
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
