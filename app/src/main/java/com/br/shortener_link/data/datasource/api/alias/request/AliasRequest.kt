package com.br.shortener_link.data.datasource.api.alias.request

import com.google.gson.annotations.SerializedName

data class AliasRequest(
    @SerializedName("url")
    private val url: String
)
