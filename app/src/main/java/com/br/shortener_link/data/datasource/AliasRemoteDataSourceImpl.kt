package com.br.shortener_link.data.datasource

import com.br.shortener_link.data.datasource.api.AliasApi
import com.br.shortener_link.data.datasource.api.dto.request.AliasRequest

class AliasRemoteDataSourceImpl(
    private val aliasApi: AliasApi
) : AliasRemoteDataSource {

    override suspend fun saveAlias(aliasRequest: AliasRequest) = aliasApi.saveAlias(aliasRequest)
}