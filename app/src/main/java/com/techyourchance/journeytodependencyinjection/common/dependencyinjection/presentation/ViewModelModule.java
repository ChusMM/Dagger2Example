package com.techyourchance.journeytodependencyinjection.common.dependencyinjection.presentation;

import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionDetailsUseCase;
import com.techyourchance.journeytodependencyinjection.screens.common.viewmodel.ViewModelFactory;
import com.techyourchance.journeytodependencyinjection.screens.questiondetails.QuestionDetailsViewModel;
import com.techyourchance.journeytodependencyinjection.screens.questionslist.QuestionsListViewModel;

import javax.inject.Provider;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {

    @Provides
    ViewModelFactory viewModelFactory(Provider<QuestionDetailsViewModel> questionDetailsViewModelProvider,
                                      Provider<QuestionsListViewModel> questionsListViewModelProvider) {
        return new ViewModelFactory(questionDetailsViewModelProvider, questionsListViewModelProvider);
    }

    @Provides
    QuestionDetailsViewModel questionDetailsViewModel(FetchQuestionDetailsUseCase fetchQuestionDetailsUseCase) {
        return new QuestionDetailsViewModel(fetchQuestionDetailsUseCase);
    }

    @Provides
    QuestionsListViewModel questionsListViewModel() {
        return new QuestionsListViewModel();
    }
}
