package com.br.shortener_link.feature.shortUrl.domain.usecase

import com.br.shortener_link.feature.shortUrl.domain.model.LinkModel
import com.br.shortener_link.feature.shortUrl.domain.model.ShortModel
import com.br.shortener_link.feature.shortUrl.domain.repository.ShortRepository
import com.br.shortener_link.feature.shortUrl.domain.state.SaveUrlState
import com.br.shortener_link.feature.shortUrl.domain.usecase.SaveUrlUseCase
import com.br.shortener_link.feature.shortUrl.presentation.mapper.mapToPresentation
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SaveUrlUseCaseTest {
    @MockK
    private lateinit var shortRepositoryMock: ShortRepository

    @MockK
    private lateinit var saveUrlUseCase: SaveUrlUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        saveUrlUseCase = SaveUrlUseCase(shortRepositoryMock)
    }

    @Test
    fun `Given string as a parameter When  save url use case is called Then return Success state`() =
        runTest {
            // Given
            val shortModel = ShortModel("alias", LinkModel("self", "short"))
            val urlString = "url_string"
            val params = SaveUrlUseCase.Params(urlString)
            coEvery { shortRepositoryMock.saveUrl(urlString) } returns shortModel
            // when
            val actualState = saveUrlUseCase.execute(params)
            // then

            assertEquals(SaveUrlState.Success(shortModel.mapToPresentation()), actualState)
        }

    @Test
    fun `Given string as a parameter When  save url use case is called Then return Fail state`() =
        runTest {
            // Given
            val urlString = "url_string"
            val params = SaveUrlUseCase.Params(urlString)
            coEvery { shortRepositoryMock.saveUrl(urlString) } throws Throwable()
            // when
            val actualState = saveUrlUseCase.execute(params)
            // then
            assertEquals(SaveUrlState.Error, actualState)
        }
}