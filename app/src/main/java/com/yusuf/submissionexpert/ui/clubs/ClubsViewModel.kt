package com.yusuf.submissionexpert.ui.clubs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yusuf.core.domain.FootballUseCase

class ClubsViewModel(footballUseCase: FootballUseCase) : ViewModel() {
    val club = footballUseCase.getAllClub().asLiveData()
}