package com.anfly.a1908a;

import android.util.Log;

/**
 * 双检锁单例设计模式
 */
public class SingleInstance {
    //变量
    private static volatile SingleInstance instance;

    //私有化构造
    private SingleInstance() {
    }

    //提供公共访问方式
    public static SingleInstance getInstance() {
        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }

    public void fun(){
        Log.e("TAG", "SingleInstance fun()");
    }
}
