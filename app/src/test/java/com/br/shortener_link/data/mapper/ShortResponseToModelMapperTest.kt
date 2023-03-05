package com.br.shortener_link.data.mapper

import com.br.shortener_link.data.shortUrl.datasource.api.dto.response.ShortResponse
import com.br.shortener_link.data.shortUrl.datasource.api.dto.response.Links
import com.br.shortener_link.data.shortUrl.mapper.alias.mapToDomain
import junit.framework.TestCase.assertEquals
import org.junit.Test


class ShortResponseToModelMapperTest {

    @Test
    fun `should mapper short response to short model`() {
        // given
        val expectedShortResponse =
            ShortResponse(alias = "alias", Links(self = "self", short = "short"))
        // when
        val actualAliasModel = expectedShortResponse.mapToDomain()
        // then
        assertEquals(expectedShortResponse.alias, actualAliasModel.alias)
        assertEquals(expectedShortResponse.links.self, actualAliasModel.link.self)
        assertEquals(expectedShortResponse.links.short, actualAliasModel.link.short)
    }
}