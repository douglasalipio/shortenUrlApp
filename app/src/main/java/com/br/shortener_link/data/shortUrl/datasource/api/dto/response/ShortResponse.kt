package com.br.shortener_link.data.shortUrl.datasource.api.dto.response

import com.google.gson.annotations.SerializedName

data class ShortResponse(
    @SerializedName("alias")
    val alias: String,
    @SerializedName("_links")
    val links: Links
)
