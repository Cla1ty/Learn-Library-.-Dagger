package com.kristal.dagger.ui.fragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kristal on 10/1/17.
 */

@Module
public class FragmentTestModule {
    @Provides
    FragmentPresenter ptovideFragmentPresenter(){
        return new FragmentPresenter();
    }
}
