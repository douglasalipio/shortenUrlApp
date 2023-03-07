package com.br.shortener_link.feature.shortUrl.domain.repository

import com.br.shortener_link.feature.shortUrl.domain.model.ShortModel

interface ShortRepository {
    suspend fun saveUrl(url: String): ShortModel
}