package com.br.shortener_link.data.mapper.alias

import com.br.shortener_link.data.datasource.api.alias.response.AliasResponse
import com.br.shortener_link.data.datasource.api.alias.response.Links
import junit.framework.TestCase.assertEquals
import org.junit.Test


class AliasResponseToModelMapperTest {

    @Test
    fun `should mapper alias response to alias model`() {
        // given
        val expectedAliasResponse =
            AliasResponse(alias = "alias", Links(self = "self", short = "short"))
        // when
        val actualAliasModel = expectedAliasResponse.mapToDomain()
        // then
        assertEquals(expectedAliasResponse.alias, actualAliasModel.alias)
        assertEquals(expectedAliasResponse.link.self, actualAliasModel.link.self)
        assertEquals(expectedAliasResponse.link.short, actualAliasModel.link.short)
    }
}