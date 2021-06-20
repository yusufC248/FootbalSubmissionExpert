package com.yusuf.core.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Club(
    val clubId: String,
    val name: String,
    val description: String,
    val stadium: String,
    val stadiumImage: String,
    val logo: String,
    val isFavorite: Boolean
) : Parcelable