package com.br.shortener_link.feature.shortUrl.data.datasource

import com.br.shortener_link.feature.shortUrl.data.datasource.api.dto.request.ShortRequest
import com.br.shortener_link.feature.shortUrl.data.datasource.api.dto.response.ShortResponse

interface ShortRemoteDataSource {

    suspend fun saveUrl(shortRequest: ShortRequest): ShortResponse
}