package com.br.shortener_link.data.datasource.api.alias.response

import com.google.gson.annotations.SerializedName

data class AliasResponse(
    @SerializedName("alias")
    val alias: String,
    @SerializedName("_links")
    val link: Links
)