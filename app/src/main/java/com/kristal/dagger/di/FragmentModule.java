package com.kristal.dagger.di;

import com.kristal.dagger.ui.fragment.BlankFragment;
import com.kristal.dagger.ui.fragment.FragmentTestModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Kristal on 10/1/17.
 */

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector(modules = FragmentTestModule.class)
    abstract BlankFragment bindBlankFragment();
}
