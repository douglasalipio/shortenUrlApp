package com.br.shortener_link.feature.shortUrl.presentation.mapper

import com.br.shortener_link.feature.shortUrl.domain.model.LinkModel
import com.br.shortener_link.feature.shortUrl.presentation.model.LinkUiModel

fun LinkModel.mapToPresentation() = LinkUiModel(this.self, this.short)