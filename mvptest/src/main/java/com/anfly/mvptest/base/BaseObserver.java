package com.anfly.mvptest.base;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<T> {

    private BaseModel mModel;
    private Disposable mDisposable;

    public BaseObserver(BaseModel model) {
        mModel = model;
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.e("TAG", "");
        mDisposable = d;
        mModel.addDisposable(mDisposable);
    }

    @Override
    public void onNext(T t) {
        onSucess(t);
        mDisposable.dispose();
        mModel.mCompositeDisposable.remove(mDisposable);
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
