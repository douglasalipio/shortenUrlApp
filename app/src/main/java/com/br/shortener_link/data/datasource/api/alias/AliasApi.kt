package com.br.shortener_link.data.datasource.api.alias

import com.br.shortener_link.data.datasource.api.alias.request.LinkRequest
import com.br.shortener_link.data.datasource.api.alias.response.AliasResponse
import retrofit2.http.Body
import retrofit2.http.PUT

interface AliasApi {

    @PUT("/api/alias")
    suspend fun saveAlias(@Body linkRequest: LinkRequest): AliasResponse

}