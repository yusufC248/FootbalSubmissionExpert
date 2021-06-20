package com.yusuf.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yusuf.core.domain.FootballUseCase

class FavoriteViewModel(footballUseCase: FootballUseCase) : ViewModel() {
    val club = footballUseCase.getFavoriteClub().asLiveData()
}