package com.br.shortener_link.data.shortUrl.repository

import com.br.shortener_link.data.shortUrl.datasource.ShortRemoteDataSource
import com.br.shortener_link.data.shortUrl.datasource.api.dto.request.ShortRequest
import com.br.shortener_link.data.shortUrl.mapper.alias.mapToDomain
import com.br.shortener_link.domain.shortUrl.repository.ShortRepository

class ShortRepositoryImpl(
    private val shortRemoteDataSource: ShortRemoteDataSource
) : ShortRepository {

    override suspend fun saveUrl(url: String) =
        shortRemoteDataSource
            .saveUrl(ShortRequest((url)))
            .mapToDomain()
}