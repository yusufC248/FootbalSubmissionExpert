package com.yusuf.core.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FootballDao {
    @Query("SELECT * FROM clubs")
    fun getAllClub(): Flow<List<ClubEntity>>

    @Query("SELECT * FROM clubs where isFavorite = 1")
    fun getFavoriteClub(): Flow<List<ClubEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClub(clubs: List<ClubEntity>)

    @Update
    fun updateFavoriteClub(clubs: ClubEntity)
}