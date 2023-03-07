@file:OptIn(ExperimentalCoroutinesApi::class)

package com.br.shortener_link.feature.shortUrl.presentation.view.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.br.shortener_link.CoroutinesTestRule
import com.br.shortener_link.core.assertNotEmitted
import com.br.shortener_link.feature.shortUrl.domain.usecase.SaveUrlUseCase
import com.br.shortener_link.feature.shortUrl.presentation.view.viewaction.ShortUrlViewAction
import com.br.shortener_link.feature.shortUrl.presentation.view.viewmodel.ShortUrlViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ShortUrlViewModelTest {

    @RelaxedMockK
    lateinit var saveUrlUseCaseMock: SaveUrlUseCase
    private lateinit var shortUrlViewModel: ShortUrlViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutinesTestRule()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        shortUrlViewModel = ShortUrlViewModel(saveUrlUseCaseMock)
    }

    @Test
    fun `Given string url When view model dispatch save url use case Then view state Show Error`() =
        coroutineTestRule.runBlockingTest {
            // given
            val params = SaveUrlUseCase.Params("url_string")
            coEvery { saveUrlUseCaseMock.execute(params) } throws Throwable()
            // when
            val viewAction = ShortUrlViewAction.SaveShortUrlClicked("urlString")
            shortUrlViewModel.dispatchViewAction(viewAction)
            // then
            shortUrlViewModel.viewState.action.assertNotEmitted()
        }
}