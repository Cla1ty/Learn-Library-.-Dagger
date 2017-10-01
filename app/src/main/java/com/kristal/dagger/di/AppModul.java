package com.kristal.dagger.di;

import android.content.Context;

import com.kristal.dagger.App;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kristal on 9/30/17.
 */

@Module
public class AppModul {
    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }
}
