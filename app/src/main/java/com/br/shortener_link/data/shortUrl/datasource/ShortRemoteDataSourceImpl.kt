package com.br.shortener_link.data.shortUrl.datasource

import com.br.shortener_link.data.shortUrl.datasource.api.ShortApi
import com.br.shortener_link.data.shortUrl.datasource.api.dto.request.ShortRequest

class ShortRemoteDataSourceImpl(
    private val shortApi: ShortApi
) : ShortRemoteDataSource {

    override suspend fun saveUrl(shortRequest: ShortRequest) = shortApi.saveUrl(shortRequest)
}