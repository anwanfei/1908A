package com.anfly.mvptest.utils;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {

    //单例获取HttpManager
    private static volatile HttpManager httpManager;
    private final Retrofit.Builder builder;

    public static HttpManager getHttpManager() {
        if (httpManager == null) {
            synchronized (HttpManager.class) {
                if (httpManager == null) {
                    httpManager = new HttpManager();
                }
            }
        }
        return httpManager;
    }

    public HttpManager() {
        builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

    }

    /**
     * 一个返回T类型的方法，T的类型的泛型
     *
     * @param baseUrl
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getApiService(String baseUrl, Class<T> clazz) {
        return builder.baseUrl(baseUrl).build().create(clazz);
    }
}
