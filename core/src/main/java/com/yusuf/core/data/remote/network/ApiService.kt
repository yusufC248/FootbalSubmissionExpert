package com.yusuf.core.data.remote.network

import com.yusuf.core.data.remote.response.ListClubResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("lookup_all_teams.php")
    suspend fun getClubList(@Query("id") listId : String
    ) : ListClubResponse
}