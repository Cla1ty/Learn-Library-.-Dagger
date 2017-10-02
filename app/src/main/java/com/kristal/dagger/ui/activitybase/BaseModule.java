package com.kristal.dagger.ui.activitybase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kristal on 10/2/17.
 */

@Module
public class BaseModule {
    @Provides
    BasePresenter provideBasePresenter() {
        return new BasePresenter();
    }

    @Provides
    ParentPresenter provideParentPresenter() {
        return new ParentPresenter();
    }
}
