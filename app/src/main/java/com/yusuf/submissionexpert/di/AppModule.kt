package com.yusuf.submissionexpert.di

import com.yusuf.core.domain.FootballInteractor
import com.yusuf.core.domain.FootballUseCase
import com.yusuf.submissionexpert.ui.clubs.ClubsViewModel
import com.yusuf.submissionexpert.ui.detail.DetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<FootballUseCase> { FootballInteractor(get()) }
}

val viewModelModule = module {
    viewModel { ClubsViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}