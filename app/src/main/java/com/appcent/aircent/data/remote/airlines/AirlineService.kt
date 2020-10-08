package com.appcent.aircent.data.remote.airlines

import com.appcent.aircent.data.remote.response.AirlinesResponse
import com.appcent.aircent.utils.mConstants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AirlineService {

    //Returns 20 items per page
    @GET("airlines?sort=%2BpublicName")
    @Headers(
        "app_id: "+mConstants.APP_ID,
        "app_key: "+mConstants.API_KEY,
        "ResourceVersion: v4",
        "Accept: application/json")
    suspend fun fetchAirlineList(
        @Query("page")
        page:Int,

    ):AirlinesResponse
}