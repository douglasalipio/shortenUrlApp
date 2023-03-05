package com.br.shortener_link.data.shortUrl.mapper.alias

import com.br.shortener_link.data.shortUrl.datasource.api.dto.response.ShortResponse
import com.br.shortener_link.domain.shortUrl.model.ShortModel


fun ShortResponse.mapToDomain() = ShortModel(this.alias, this.links.mapToDomain())