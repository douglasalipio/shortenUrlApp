@file:OptIn(ExperimentalCoroutinesApi::class)

package com.br.shortener_link.data.datasource

import com.br.shortener_link.data.shortUrl.datasource.ShortRemoteDataSource
import com.br.shortener_link.data.shortUrl.datasource.ShortRemoteDataSourceImpl
import com.br.shortener_link.data.shortUrl.datasource.api.ShortApi
import com.br.shortener_link.data.shortUrl.datasource.api.dto.request.ShortRequest
import com.br.shortener_link.data.shortUrl.datasource.api.dto.response.Links
import com.br.shortener_link.data.shortUrl.datasource.api.dto.response.ShortResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ShortRemoteDataSourceTest {

    @MockK
    private lateinit var shortApiMock: ShortApi
    private lateinit var shortRemoteDataSource: ShortRemoteDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        shortRemoteDataSource = ShortRemoteDataSourceImpl(shortApiMock)
    }

    @Test
    fun `GIVEN link request WHEN remote data source save url THEN return Short Response`() =
        runTest {
            // given
            val shortResponse = ShortResponse("alias", Links("self", "short"))
            val shortRequest = ShortRequest("url")
            coEvery { shortApiMock.saveUrl(shortRequest) } returns shortResponse

            // when
            val actualAliasResponse = shortRemoteDataSource.saveUrl(shortRequest)

            // then
            coVerify(exactly = 1) { shortApiMock.saveUrl(shortRequest) }
            assertNotNull(actualAliasResponse)
        }
}