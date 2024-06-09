package com.github.faening.engsofttmdb.data.model.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponsePageApiData<T>(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: List<T>,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_results")
    val totalResults: Int
) : Serializable