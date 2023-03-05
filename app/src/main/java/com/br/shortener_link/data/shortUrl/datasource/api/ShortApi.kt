package com.br.shortener_link.data.shortUrl.datasource.api

import com.br.shortener_link.data.shortUrl.datasource.api.dto.request.ShortRequest
import com.br.shortener_link.data.shortUrl.datasource.api.dto.response.ShortResponse
import retrofit2.http.Body
import retrofit2.http.PUT

interface ShortApi {

    @PUT("/api/alias")
    suspend fun saveUrl(@Body shortRequest: ShortRequest): ShortResponse

}