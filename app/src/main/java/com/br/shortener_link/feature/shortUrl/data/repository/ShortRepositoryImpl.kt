package com.br.shortener_link.feature.shortUrl.data.repository

import com.br.shortener_link.feature.shortUrl.data.datasource.ShortRemoteDataSource
import com.br.shortener_link.feature.shortUrl.data.datasource.api.dto.request.ShortRequest
import com.br.shortener_link.feature.shortUrl.data.mapper.mapToDomain
import com.br.shortener_link.feature.shortUrl.domain.repository.ShortRepository

class ShortRepositoryImpl(
    private val shortRemoteDataSource: ShortRemoteDataSource
) : ShortRepository {

    override suspend fun saveUrl(url: String) =
        shortRemoteDataSource
            .saveUrl(ShortRequest((url)))
            .mapToDomain()
}