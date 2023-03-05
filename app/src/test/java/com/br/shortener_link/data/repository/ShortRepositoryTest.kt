@file:OptIn(ExperimentalCoroutinesApi::class)

package com.br.shortener_link.data.repository

import com.br.shortener_link.data.shortUrl.datasource.ShortRemoteDataSource
import com.br.shortener_link.data.shortUrl.datasource.api.dto.request.ShortRequest
import com.br.shortener_link.data.shortUrl.datasource.api.dto.response.ShortResponse
import com.br.shortener_link.data.shortUrl.datasource.api.dto.response.Links
import com.br.shortener_link.data.shortUrl.repository.ShortRepositoryImpl
import com.br.shortener_link.domain.shortUrl.repository.ShortRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class ShortRepositoryTest {

    @MockK
    private lateinit var shortRemoteDataSourceMock: ShortRemoteDataSource
    private lateinit var shortRepository: ShortRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        shortRepository = ShortRepositoryImpl(shortRemoteDataSourceMock)
    }

    @Test
    fun `GIVEN url string WHEN repository save url THEN return Short Model`() = runTest {
        // given
        val shortResponse = ShortResponse("alias", Links("self", "short"))
        val url = "url"
        val shortRequest = ShortRequest(url)
        coEvery { shortRemoteDataSourceMock.saveUrl(shortRequest) } returns shortResponse

        // when
        val actualAliasModel = shortRepository.saveUrl(url)

        // then
        coVerify(exactly = 1) { shortRemoteDataSourceMock.saveUrl(shortRequest) }
        assertNotNull(actualAliasModel)
    }
}