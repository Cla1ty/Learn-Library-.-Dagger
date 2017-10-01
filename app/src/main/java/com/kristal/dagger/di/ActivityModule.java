package com.kristal.dagger.di;

import com.kristal.dagger.ui.MainActivity;
import com.kristal.dagger.ui.MainAtivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Kristal on 10/1/17.
 */

@Module
public abstract class ActivityModule {
    // nama activity harus sama
    @ContributesAndroidInjector(modules = MainAtivityModule.class)
    abstract MainActivity bindLobbyActivity();
}
