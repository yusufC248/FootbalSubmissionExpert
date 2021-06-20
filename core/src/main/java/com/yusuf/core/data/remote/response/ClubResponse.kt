package com.yusuf.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class ClubResponse (
    @field:SerializedName("idTeam")
    val id: String,

    @field:SerializedName("strTeam")
    val name: String,

    @field:SerializedName("strDescriptionEN")
    val description: String,

    @field:SerializedName("strStadium")
    val stadium: String,

    @field:SerializedName("strStadiumThumb")
    val stadiumImage: String,

    @field:SerializedName("strTeamBadge")
    val logo: String

    )