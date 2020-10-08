package com.appcent.aircent.data.remote.response


import com.google.gson.annotations.SerializedName

data class AirlinesResponse(
    @SerializedName("airlines")
    val airlines: List<Airline>
)