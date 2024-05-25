package com.github.faening.engsofttmdb.api.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CreditsData(
    @SerializedName("id")
    val id : Int,

    @SerializedName("cast")
    val cast : List<CastData>,

    @SerializedName("crew")
    val crew : List<CrewData>
) : Serializable

