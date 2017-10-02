package com.kristal.dagger.ui.include;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kristal on 10/1/17.
 */

@Module
public class IncludeModule {
    @Provides
    IncludeProvider provideActivityPresenterProvider(){
        return new IncludeProvider();
    }
}
