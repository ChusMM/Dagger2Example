package com.techyourchance.journeytodependencyinjection.screens.common.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.techyourchance.journeytodependencyinjection.screens.questiondetails.QuestionDetailsViewModel;
import com.techyourchance.journeytodependencyinjection.screens.questionslist.QuestionsListViewModel;

import javax.inject.Provider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Provider<QuestionDetailsViewModel> questionDetailsViewModelProvider;
    private final Provider<QuestionsListViewModel> questionsListViewModelProvider;


    public ViewModelFactory(Provider<QuestionDetailsViewModel> questionDetailsViewModelProvider,
                            Provider<QuestionsListViewModel> questionsListViewModelProvider) {
        this.questionDetailsViewModelProvider = questionDetailsViewModelProvider;
        this.questionsListViewModelProvider = questionsListViewModelProvider;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        ViewModel viewModel;
        if (modelClass == QuestionDetailsViewModel.class) {
            viewModel = questionDetailsViewModelProvider.get();
        }
        else if (modelClass == QuestionsListViewModel.class) {
            viewModel = questionsListViewModelProvider.get();
        }
        else {
            throw new RuntimeException("invalid view model class: " + modelClass);
        }

        return (T) viewModel;
    }
}
