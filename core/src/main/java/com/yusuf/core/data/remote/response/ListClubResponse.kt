package com.yusuf.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class ListClubResponse(
    @field:SerializedName("teams")
    val clubs: List<ClubResponse>
)
