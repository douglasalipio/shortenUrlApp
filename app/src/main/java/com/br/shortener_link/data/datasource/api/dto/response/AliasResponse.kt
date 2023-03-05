package com.br.shortener_link.data.datasource.api.dto.response

import com.google.gson.annotations.SerializedName

data class AliasResponse(
    @SerializedName("alias")
    val alias: String,
    @SerializedName("_links")
    val link: Links
)