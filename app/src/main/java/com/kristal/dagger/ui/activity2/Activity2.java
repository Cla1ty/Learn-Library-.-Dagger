package com.kristal.dagger.ui.activity2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.kristal.dagger.R;
import com.kristal.dagger.Trace;
import com.kristal.dagger.di.AppObject;
import com.kristal.dagger.ui.activity.ActivityPresenterInject;
import com.kristal.dagger.ui.activitybase.ActivityParent;
import com.kristal.dagger.ui.include.IncludeProvider;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;

public class Activity2 extends AppCompatActivity //implements HasSupportFragmentInjector
{

    //    @Inject
    DispatchingAndroidInjector<Fragment> injector;
    @Inject
    AppObject appObject;
    @Inject
    Context context;
    @Inject
    ActivityPresenterInject presenterInject;
    //    sama seperti app tidak bisa akses activityLain
//    @Inject
//    ActivityPresenterProvider presenterProvider;
    @Inject
    IncludeProvider presenterProvider3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // inject harus sebelum super
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Trace.debug("Activity2 " + appObject);
        Trace.debug("Activity2 " + context);
        Trace.debug("Activity2 " + presenterInject);
        Trace.debug("Activity2 " + presenterProvider3);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startActivity(new Intent(this, ActivityParent.class));
    }

    //    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return injector;
    }
}
