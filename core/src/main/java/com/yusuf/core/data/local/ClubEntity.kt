package com.yusuf.core.data.local

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clubs")
data class ClubEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "clubId")
    var clubId: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "stadium")
    var stadium: String,

    @ColumnInfo(name = "stadium_image")
    var stadiumImage: String,

    @ColumnInfo(name = "logo")
    var logo: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)