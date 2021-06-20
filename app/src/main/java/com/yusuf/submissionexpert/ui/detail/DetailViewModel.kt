package com.yusuf.submissionexpert.ui.detail

import androidx.lifecycle.ViewModel
import com.yusuf.core.domain.Club
import com.yusuf.core.domain.FootballUseCase

class DetailViewModel(private val footballUseCase: FootballUseCase) : ViewModel() {
    fun setFavoriteClub(club: Club, newStatus:Boolean) =
        footballUseCase.setFavoriteClub(club, newStatus)
}