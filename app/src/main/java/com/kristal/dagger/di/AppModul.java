package com.kristal.dagger.di;

import android.content.Context;

import com.kristal.dagger.App;
import com.kristal.dagger.ui.include.IncludeModule;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kristal on 9/30/17.
 */

// include sama seperti extend
@Module(includes = IncludeModule.class)
public class AppModul {
    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }
}
