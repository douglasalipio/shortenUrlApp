package com.br.shortener_link.data.repository

import com.br.shortener_link.data.datasource.AliasRemoteDataSource
import com.br.shortener_link.data.datasource.api.dto.request.AliasRequest
import com.br.shortener_link.data.mapper.alias.mapToDomain
import com.br.shortener_link.domain.repository.AliasRepository

class AliasRepositoryImpl(
    private val aliasRemoteDataSource: AliasRemoteDataSource
) : AliasRepository {

    override suspend fun saveAlias(url: String) =
        aliasRemoteDataSource
            .saveAlias(AliasRequest((url)))
            .mapToDomain()
}