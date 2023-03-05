package com.br.shortener_link.data.shortUrl.mapper.alias

import com.br.shortener_link.data.shortUrl.datasource.api.dto.response.Links
import com.br.shortener_link.domain.shortUrl.model.LinkModel

fun Links.mapToDomain() = LinkModel(this.self,this.short)