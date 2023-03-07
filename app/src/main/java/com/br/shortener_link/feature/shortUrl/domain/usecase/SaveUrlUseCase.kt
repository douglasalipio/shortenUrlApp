package com.br.shortener_link.feature.shortUrl.domain.usecase

import com.br.shortener_link.feature.shortUrl.domain.repository.ShortRepository
import com.br.shortener_link.feature.shortUrl.domain.state.SaveUrlState
import com.br.shortener_link.feature.shortUrl.presentation.mapper.mapToPresentation

class SaveUrlUseCase(private val shortRepository: ShortRepository) {

    suspend fun execute(params: Params): SaveUrlState = try {
        val shortModel = shortRepository.saveUrl(params.url)
        SaveUrlState.Success(shortModel.mapToPresentation())
    } catch (throwable: Throwable) {
        SaveUrlState.Error
    }

    data class Params(val url: String)
}