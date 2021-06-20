package com.yusuf.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ClubEntity::class], version = 1, exportSchema = false)
abstract class FootballDatabase : RoomDatabase() {

    abstract fun footballDao(): FootballDao
}