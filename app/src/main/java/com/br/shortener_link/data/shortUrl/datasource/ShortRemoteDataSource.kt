package com.br.shortener_link.data.shortUrl.datasource

import com.br.shortener_link.data.shortUrl.datasource.api.dto.request.ShortRequest
import com.br.shortener_link.data.shortUrl.datasource.api.dto.response.ShortResponse

interface ShortRemoteDataSource {

    suspend fun saveUrl(shortRequest: ShortRequest): ShortResponse
}