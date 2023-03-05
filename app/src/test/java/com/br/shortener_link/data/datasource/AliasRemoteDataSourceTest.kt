@file:OptIn(ExperimentalCoroutinesApi::class)

package com.br.shortener_link.data.datasource

import com.br.shortener_link.data.datasource.api.AliasApi
import com.br.shortener_link.data.datasource.api.dto.request.AliasRequest
import com.br.shortener_link.data.datasource.api.dto.response.AliasResponse
import com.br.shortener_link.data.datasource.api.dto.response.Links
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class AliasRemoteDataSourceTest {

    @MockK
    private lateinit var aliasApiMock: AliasApi
    private lateinit var aliasRemoteDataSource: AliasRemoteDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        aliasRemoteDataSource = AliasRemoteDataSourceImpl(aliasApiMock)
    }

    @Test
    fun `GIVEN link request WHEN save alias is called THEN return Alias Response`() = runTest {
        // given
        val aliasResponse = AliasResponse("alias", Links("self", "short"))
        val aliasRequest = AliasRequest("url")
        coEvery { aliasApiMock.saveAlias(aliasRequest) } returns aliasResponse

        // when
        val actualAliasResponse = aliasRemoteDataSource.saveAlias(aliasRequest)

        // then
        coVerify(exactly = 1) { aliasApiMock.saveAlias(aliasRequest) }
        assertNotNull(actualAliasResponse)
    }
}