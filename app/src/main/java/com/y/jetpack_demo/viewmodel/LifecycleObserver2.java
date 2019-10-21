package com.y.jetpack_demo.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.y.jetpack_demo.util.L;

public class LifecycleObserver2 implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume(){
        L.e("onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(){
        L.e("onDestroy");
    }

}
