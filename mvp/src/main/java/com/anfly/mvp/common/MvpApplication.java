package com.anfly.mvp.common;

import android.app.Application;

public class MvpApplication extends Application {
    private static MvpApplication app;

    public static MvpApplication getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
