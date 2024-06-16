package com.github.faening.engsofttmdb.data.model.api.videos

import java.io.Serializable
import com.google.gson.annotations.SerializedName

data class VideoApiData(
    @SerializedName("iso_639_1")
    val iso6391: String,

    @SerializedName("iso_3166_1")
    val iso31661: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("key")
    val key: String,

    @SerializedName("site")
    val site: String,

    @SerializedName("size")
    val size: Int,

    @SerializedName("type")
    val type: String,

    @SerializedName("official")
    val official: Boolean,

    @SerializedName("published_at")
    val publishedAt: String,

    @SerializedName("id")
    val tmdbId: String
) : Serializable
