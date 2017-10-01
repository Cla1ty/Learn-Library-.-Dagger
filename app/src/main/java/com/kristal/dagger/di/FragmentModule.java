package com.kristal.dagger.di;

import com.kristal.dagger.ui.BlankFragment;
import com.kristal.dagger.ui.BlankFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Kristal on 10/1/17.
 */

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector(modules = BlankFragmentModule.class)
    abstract BlankFragment bindBlankFragment();
}
