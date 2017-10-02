package com.kristal.dagger.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.kristal.dagger.R;
import com.kristal.dagger.Trace;
import com.kristal.dagger.di.AppObject;
import com.kristal.dagger.ui.activity2.Activity2;
import com.kristal.dagger.ui.fragment.BlankFragment;
import com.kristal.dagger.ui.include.IncludeProvider;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class Activity extends AppCompatActivity implements ActivityView, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> injector;
    @Inject
    AppObject appObject;
    @Inject
    Context context;
    @Inject
    ActivityPresenterInject presenterInject;
    @Inject
    ActivityPresenterProvider presenterProvider;
    @Inject
    IncludeProvider presenterProvider3;
    @Inject
    ActivityPresenterProviderWithParameter withParameter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // inject harus sebelum super
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Trace.debug("Activity " + appObject);
        Trace.debug("Activity " + context);
        Trace.debug("Activity " + presenterInject);
        Trace.debug("Activity " + presenterProvider);
        Trace.debug("Activity " + presenterProvider3);
        Trace.debug("Activity " + withParameter);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new BlankFragment())
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        startActivity(new Intent(this, Activity2.class));
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return injector;
    }
}
