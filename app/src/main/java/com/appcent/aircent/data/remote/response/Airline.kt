package com.appcent.aircent.data.remote.response


import com.google.gson.annotations.SerializedName

data class Airline(
    @SerializedName("iata")
    val iata: String?,
    @SerializedName("icao")
    val icao: String?,
    @SerializedName("nvls")
    val nvls: Int,
    @SerializedName("publicName")
    val publicName: String
)