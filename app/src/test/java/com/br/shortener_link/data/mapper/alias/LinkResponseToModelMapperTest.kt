package com.br.shortener_link.data.mapper.alias

import com.br.shortener_link.data.datasource.api.alias.response.Links
import junit.framework.TestCase.assertEquals
import org.junit.Test


class LinkResponseToModelMapperTest {

    @Test
    fun `should mapper alias response to alias model`() {
        // given
        val expectedLinkResponse = Links(self = "self", short = "short")
        // when
        val actualLinkModel = expectedLinkResponse.mapToDomain()
        // then
        assertEquals(expectedLinkResponse.self, actualLinkModel.self)
        assertEquals(expectedLinkResponse.short, actualLinkModel.short)
    }
}