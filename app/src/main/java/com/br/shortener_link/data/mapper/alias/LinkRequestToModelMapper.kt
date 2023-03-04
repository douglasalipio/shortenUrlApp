package com.br.shortener_link.data.mapper.alias

import com.br.shortener_link.data.datasource.api.alias.response.Links
import com.br.shortener_link.domain.model.LinkModel

fun  Links.mapToDomain() = LinkModel(this.self,this.short)