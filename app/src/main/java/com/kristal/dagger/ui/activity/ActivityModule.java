package com.kristal.dagger.ui.activity;

import com.kristal.dagger.di.AppObject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kristal on 10/1/17.
 */

@Module
public class ActivityModule {
    @Provides
    ActivityPresenterProvider provideActivityPresenterProvider(){
        return new ActivityPresenterProvider();
    }
    @Provides
    ActivityPresenterProviderWithParameter providerWithParameter(AppObject appObject, ActivityView view){
        return new ActivityPresenterProviderWithParameter(appObject, view);
    }
    @Provides
    ActivityView provideView(Activity activity){
        return activity;
    }
}
