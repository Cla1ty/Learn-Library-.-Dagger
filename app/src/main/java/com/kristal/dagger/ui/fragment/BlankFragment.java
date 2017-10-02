package com.kristal.dagger.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kristal.dagger.R;
import com.kristal.dagger.Trace;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class BlankFragment extends Fragment {
    @Inject
    FragmentPresenter fragmentPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false);
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        Trace.debug("Fragment " +fragmentPresenter);

    }
}
