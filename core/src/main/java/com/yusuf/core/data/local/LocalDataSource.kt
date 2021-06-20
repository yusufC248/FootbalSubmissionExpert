package com.yusuf.core.data.local

import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val footballDao: FootballDao) {

    fun getAllClub(): Flow<List<ClubEntity>> = footballDao.getAllClub()

    fun getFavoriteClub(): Flow<List<ClubEntity>> = footballDao.getFavoriteClub()

    suspend fun insertClub(clubs: List<ClubEntity>) = footballDao.insertClub(clubs)

    fun setFavoriteClub(club: ClubEntity, newState: Boolean) {
        club.isFavorite = newState
        footballDao.updateFavoriteClub(club)
    }
}