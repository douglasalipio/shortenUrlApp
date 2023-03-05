package com.br.shortener_link.data.datasource

import com.br.shortener_link.data.datasource.api.dto.request.AliasRequest
import com.br.shortener_link.data.datasource.api.dto.response.AliasResponse

interface AliasRemoteDataSource {

    suspend fun saveAlias(aliasRequest: AliasRequest): AliasResponse
}