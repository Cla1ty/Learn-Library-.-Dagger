package com.kristal.dagger.ui.fragment;

import android.content.Context;

import com.kristal.dagger.Trace;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;


public class FragmentTest extends android.support.v4.app.Fragment {
    @Inject
    FragmentPresenter fragmentPresenter;

    // Untuk fragment bukan di onCreate tp di onAttach
    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);

        Trace.debug("Fragment " +fragmentPresenter);
    }
}
