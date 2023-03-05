package com.br.shortener_link.domain.shortUrl.repository

import com.br.shortener_link.domain.shortUrl.model.ShortModel

interface ShortRepository {
    suspend fun saveUrl(url: String): ShortModel
}