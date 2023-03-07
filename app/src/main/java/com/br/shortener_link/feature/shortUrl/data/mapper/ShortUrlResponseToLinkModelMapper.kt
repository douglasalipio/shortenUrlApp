package com.br.shortener_link.feature.shortUrl.data.mapper

import com.br.shortener_link.feature.shortUrl.data.datasource.api.dto.response.ShortResponse
import com.br.shortener_link.feature.shortUrl.domain.model.ShortModel


fun ShortResponse.mapToDomain() = ShortModel(this.alias, this.links.mapToDomain())