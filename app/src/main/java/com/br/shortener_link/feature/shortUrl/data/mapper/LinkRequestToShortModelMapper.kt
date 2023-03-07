package com.br.shortener_link.feature.shortUrl.data.mapper

import com.br.shortener_link.feature.shortUrl.data.datasource.api.dto.response.Links
import com.br.shortener_link.feature.shortUrl.domain.model.LinkModel

fun Links.mapToDomain() = LinkModel(this.self,this.short)