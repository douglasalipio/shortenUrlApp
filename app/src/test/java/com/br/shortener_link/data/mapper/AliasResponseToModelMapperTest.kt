package com.br.shortener_link.data.mapper

import com.br.shortener_link.data.datasource.api.dto.response.AliasResponse
import com.br.shortener_link.data.datasource.api.dto.response.Links
import com.br.shortener_link.data.mapper.alias.mapToDomain
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
        assertEquals(expectedAliasResponse.links.self, actualAliasModel.link.self)
        assertEquals(expectedAliasResponse.links.short, actualAliasModel.link.short)
    }
}