package com.techyourchance.journeytodependencyinjection.screens.questiondetails;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techyourchance.journeytodependencyinjection.screens.common.fragments.BaseFragment;
import com.techyourchance.journeytodependencyinjection.screens.common.viewmodel.ViewModelFactory;

import javax.inject.Inject;

/**
 * Created by Jesús Manuel Muñoz Mazuecos
 * on 19/02/2019.
 * email: jmanuel_munoz@iecisa.com
 */
public class SimpleFragment extends BaseFragment {

    @Inject
    ViewModelFactory mViewModelFactory;

    private QuestionDetailsViewModel mFragmentVm;
    private QuestionDetailsViewModel mActivityVm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresentationComponent().inject(this);

        mFragmentVm = ViewModelProviders.of(this, mViewModelFactory)
                .get(QuestionDetailsViewModel.class);

        mActivityVm = ViewModelProviders.of(this, mViewModelFactory)
                .get(QuestionDetailsViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());

        if (mFragmentVm == mActivityVm) {
            textView.setText("View models are the same");
        } else {
            textView.setText("View models are different");
        }

        return textView;
    }
}
