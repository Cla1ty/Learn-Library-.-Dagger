package com.kristal.dagger.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.kristal.dagger.R;
import com.kristal.dagger.di.MovieMaker;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector{

    @Inject
    DispatchingAndroidInjector<Fragment> injector;
    @Inject
    MovieMaker singletonMaker;
    @Inject
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // inject harus sebelum super
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("A", "Movie " + singletonMaker);
        Log.d("A", "Movie " + context);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return injector;
    }
}
