package com.kristal.dagger;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.kristal.dagger.di.AppObject;
import com.kristal.dagger.di.DaggerAppComponent;
import com.kristal.dagger.ui.activity.ActivityPresenterInject;
import com.kristal.dagger.ui.include.IncludeProvider;

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
    AppObject appObject;
    @Inject
    Context context;
    @Inject
    ActivityPresenterInject presenterInject;

    // dari provider tidak bisa
//    @Inject
//    ActivityPresenterProvider presenterProvider;

    @Inject
    IncludeProvider presenterProvider3;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

        Trace.debug("APP: " + context);
        Trace.debug("APP: " + appObject);
        Trace.debug("APP: " + presenterInject);
        Trace.debug("APP: " + presenterProvider3);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return injector;
    }
}
