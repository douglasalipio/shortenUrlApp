package com.br.shortener_link.feature.shortUrl.domain.state

import com.br.shortener_link.feature.shortUrl.presentation.model.ShortUiModel

sealed class SaveUrlState {
    data class Success(val shortUiModel: ShortUiModel) : SaveUrlState()
    object Error : SaveUrlState()
}