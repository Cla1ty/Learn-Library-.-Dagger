package com.kristal.dagger.ui.activitybase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kristal.dagger.R;
import com.kristal.dagger.Trace;

import javax.inject.Inject;

public class BaseActivity extends AppCompatActivity {
    // BaseActivity bisa menggunakan incector ActivityParent
    @Inject
    BasePresenter basePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Trace.debug("BaseActivity " + basePresenter);
    }
}
