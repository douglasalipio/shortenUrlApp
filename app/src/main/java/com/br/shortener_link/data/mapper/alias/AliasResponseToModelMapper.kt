package com.br.shortener_link.data.mapper.alias

import com.br.shortener_link.data.datasource.api.alias.response.AliasResponse
import com.br.shortener_link.domain.model.AliasModel


fun AliasResponse.mapToDomain() = AliasModel(this.alias, this.link.mapToDomain())