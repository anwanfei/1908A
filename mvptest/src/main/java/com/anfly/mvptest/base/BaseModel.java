package com.anfly.mvptest.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    public CompositeDisposable mCompositeDisposable;

    public void onDestory() {
        //切断所有的Disposable对象
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    public void addDisposable(Disposable d) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(d);
    }
}
