package com.br.shortener_link.data.datasource.api.alias.response

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("self")
    val self: String,
    @SerializedName("short")
    val short: String
)