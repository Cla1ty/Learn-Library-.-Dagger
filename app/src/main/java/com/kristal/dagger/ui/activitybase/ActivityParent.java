package com.kristal.dagger.ui.activitybase;

import android.os.Bundle;

import com.kristal.dagger.Trace;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by Kristal on 10/2/17.
 */

public class ActivityParent extends BaseActivity{
@Inject
ParentPresenter parentPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        Trace.debug("Activity Base " + parentPresenter);
    }
}
