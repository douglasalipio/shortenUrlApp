@file:OptIn(ExperimentalCoroutinesApi::class)

package com.br.shortener_link.data.repository

import com.br.shortener_link.data.datasource.AliasRemoteDataSource
import com.br.shortener_link.data.datasource.api.dto.request.AliasRequest
import com.br.shortener_link.data.datasource.api.dto.response.AliasResponse
import com.br.shortener_link.data.datasource.api.dto.response.Links
import com.br.shortener_link.domain.repository.AliasRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class AliasRepositoryTest {

    @MockK
    private lateinit var aliasRemoteDataSourceMock: AliasRemoteDataSource
    private lateinit var aliasRepository: AliasRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        aliasRepository = AliasRepositoryImpl(aliasRemoteDataSourceMock)
    }

    @Test
    fun `GIVEN link request WHEN save alias is called THEN return Alias Model`() = runTest {
        // given
        val aliasResponse = AliasResponse("alias", Links("self", "short"))
        val url = "url"
        val aliasRequest = AliasRequest(url)
        coEvery { aliasRemoteDataSourceMock.saveAlias(aliasRequest) } returns aliasResponse

        // when
        val actualAliasModel = aliasRepository.saveAlias(url)

        // then
        coVerify(exactly = 1) { aliasRemoteDataSourceMock.saveAlias(aliasRequest) }
        assertNotNull(actualAliasModel)
    }
}