package com.br.shortener_link.feature.shortUrl.presentation.mapper

import com.br.shortener_link.feature.shortUrl.domain.model.ShortModel
import com.br.shortener_link.feature.shortUrl.presentation.model.ShortUiModel


fun ShortModel.mapToPresentation() = ShortUiModel(this.alias, this.link.mapToPresentation())