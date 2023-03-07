package com.br.shortener_link.feature.shortUrl.presentation.view.viewaction

sealed class ShortUrlViewAction {

    data class SaveShortUrlClicked(val urlString: String) : ShortUrlViewAction()
}