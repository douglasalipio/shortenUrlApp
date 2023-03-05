package com.br.shortener_link.data.mapper

import com.br.shortener_link.data.shortUrl.datasource.api.dto.response.Links
import com.br.shortener_link.data.shortUrl.mapper.alias.mapToDomain
import junit.framework.TestCase.assertEquals
import org.junit.Test


class LinkResponseToModelMapperTest {

    @Test
    fun `should mapper links to link model`() {
        // given
        val expectedLinkResponse = Links(self = "self", short = "short")
        // when
        val actualLinkModel = expectedLinkResponse.mapToDomain()
        // then
        assertEquals(expectedLinkResponse.self, actualLinkModel.self)
        assertEquals(expectedLinkResponse.short, actualLinkModel.short)
    }
}