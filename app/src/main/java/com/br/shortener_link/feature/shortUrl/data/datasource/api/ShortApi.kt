package com.br.shortener_link.feature.shortUrl.data.datasource.api

import com.br.shortener_link.feature.shortUrl.data.datasource.api.dto.request.ShortRequest
import com.br.shortener_link.feature.shortUrl.data.datasource.api.dto.response.ShortResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT

interface ShortApi {

    @Headers("Content-Type: application/json")
    @POST("/api/alias")
    suspend fun saveUrl(@Body shortRequest: ShortRequest): ShortResponse

}