package com.br.shortener_link.feature.shortUrl.data.datasource.api.dto.request

import com.google.gson.annotations.SerializedName

data class ShortRequest(
    @SerializedName("url")
    private val url: String
)