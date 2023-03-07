package com.br.shortener_link.feature.shortUrl.data.datasource.api.dto.response

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("self")
    val self: String,
    @SerializedName("short")
    val short: String
)