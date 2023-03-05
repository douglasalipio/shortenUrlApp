package com.br.shortener_link.domain.repository

import com.br.shortener_link.domain.model.AliasModel

interface AliasRepository {
    suspend fun saveAlias(url: String) : AliasModel
}