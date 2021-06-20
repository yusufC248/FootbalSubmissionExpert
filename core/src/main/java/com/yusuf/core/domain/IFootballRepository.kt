package com.yusuf.core.domain


import com.yusuf.core.data.Resource
import kotlinx.coroutines.flow.Flow

interface IFootballRepository {
    fun getAllClub(): Flow<Resource<List<Club>>>

    fun getFavoriteClub(): Flow<List<Club>>

    fun setFavoriteClub(club: Club, state: Boolean)
}