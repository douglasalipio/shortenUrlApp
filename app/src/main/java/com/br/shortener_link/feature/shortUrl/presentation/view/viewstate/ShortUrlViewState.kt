package com.br.shortener_link.feature.shortUrl.presentation.view.viewstate

import androidx.lifecycle.MutableLiveData
import com.br.shortener_link.feature.shortUrl.presentation.model.ShortUiModel

class ShortUrlViewState {

    val action: MutableLiveData<Action> = MutableLiveData()

    sealed class Action {
        data class ShowSuccess(val shortUiModel: ShortUiModel) : Action()
        object ShowError : Action()
    }
}