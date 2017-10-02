package com.kristal.dagger.di;

import com.kristal.dagger.ui.activity.Activity;
import com.kristal.dagger.ui.activity2.Activity2;
import com.kristal.dagger.ui.activity2.ActivityModule2;
import com.kristal.dagger.ui.activitybase.ActivityParent;
import com.kristal.dagger.ui.activitybase.BaseModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Kristal on 10/1/17.
 */

@Module
public abstract class ActivityModule {
    // nama activity harus sama
    @ContributesAndroidInjector(modules = com.kristal.dagger.ui.activity.ActivityModule.class)
    abstract Activity bindLobbyActivity();
    @ContributesAndroidInjector(modules = ActivityModule2.class)
    abstract Activity2 bindLobbyActivity2();

    // yang bisa di inject hanya activity oaling atas, tidak bisa BaseActivity
    @ContributesAndroidInjector(modules = BaseModule.class)
    abstract ActivityParent bindBaseActivity();
}
