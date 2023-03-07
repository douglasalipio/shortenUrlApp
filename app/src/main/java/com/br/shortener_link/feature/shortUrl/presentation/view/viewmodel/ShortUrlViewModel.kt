package com.br.shortener_link.feature.shortUrl.presentation.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.shortener_link.core.PresentationModel
import com.br.shortener_link.feature.shortUrl.domain.state.SaveUrlState
import com.br.shortener_link.feature.shortUrl.domain.usecase.SaveUrlUseCase
import com.br.shortener_link.feature.shortUrl.presentation.model.ShortUiModel
import com.br.shortener_link.feature.shortUrl.presentation.view.viewaction.ShortUrlViewAction
import com.br.shortener_link.feature.shortUrl.presentation.view.viewstate.ShortUrlViewState
import kotlinx.coroutines.launch

class ShortUrlViewModel(
    private val saveUrlUseCase: SaveUrlUseCase
) : ViewModel(), PresentationModel<ShortUrlViewState, ShortUrlViewAction> {

    override val viewState = ShortUrlViewState()

    override fun dispatchViewAction(viewAction: ShortUrlViewAction) {
        when (viewAction) {
            is ShortUrlViewAction.SaveShortUrlClicked -> saveUrlString(viewAction.urlString)
        }
    }

    private fun saveUrlString(urlString: String) {
        viewModelScope.launch {
            val params = SaveUrlUseCase.Params(urlString)

            when (val saveUrlState = saveUrlUseCase.execute(params)) {
                is SaveUrlState.Success -> dispatchShowSuccess(saveUrlState.shortUiModel)
                is SaveUrlState.Error -> dispatchShowError()
            }
        }
    }

    private fun dispatchShowSuccess(shortUiModel: ShortUiModel) {
        viewState.action.value = ShortUrlViewState.Action.ShowSuccess(shortUiModel)
    }

    private fun dispatchShowError() {
        viewState.action.value = ShortUrlViewState.Action.ShowError
    }
}