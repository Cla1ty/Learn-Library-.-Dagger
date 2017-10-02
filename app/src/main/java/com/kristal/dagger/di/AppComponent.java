package com.kristal.dagger.di;

import com.kristal.dagger.App;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Kristal on 9/30/17.
 */

@Component(modules = {
        AndroidInjectionModule.class,
        AppModul.class,
        ActivityModule.class,
        FragmentModule.class
})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App application);

        AppComponent build();
    }

    // nama applicationnya harus sama, tidak boleh child class, seperti activity
    void inject(App application);
}
