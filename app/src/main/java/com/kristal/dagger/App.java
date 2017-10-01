package com.kristal.dagger;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.kristal.dagger.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by Kristal on 10/1/17.
 */

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> injector;
    @Inject
    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

        Log.d("a", "Context: " + injector);
        Log.d("a", "Context: " + context);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return injector;
    }
}
