package com.br.shortener_link.feature.shortUrl.data.datasource

import com.br.shortener_link.feature.shortUrl.data.datasource.api.ShortApi
import com.br.shortener_link.feature.shortUrl.data.datasource.api.dto.request.ShortRequest

class ShortRemoteDataSourceImpl(
    private val shortApi: ShortApi
) : ShortRemoteDataSource {

    override suspend fun saveUrl(shortRequest: ShortRequest) = shortApi.saveUrl(shortRequest)
}