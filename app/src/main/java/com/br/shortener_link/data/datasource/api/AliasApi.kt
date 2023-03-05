package com.br.shortener_link.data.datasource.api

import com.br.shortener_link.data.datasource.api.dto.request.AliasRequest
import com.br.shortener_link.data.datasource.api.dto.response.AliasResponse
import retrofit2.http.Body
import retrofit2.http.PUT

interface AliasApi {

    @PUT("/api/alias")
    suspend fun saveAlias(@Body aliasRequest: AliasRequest): AliasResponse

}