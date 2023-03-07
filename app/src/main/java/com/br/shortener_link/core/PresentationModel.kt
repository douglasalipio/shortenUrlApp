package com.br.shortener_link.core

interface PresentationModel<T, A> {
    val viewState: T
    fun dispatchViewAction(viewAction: A)
}
