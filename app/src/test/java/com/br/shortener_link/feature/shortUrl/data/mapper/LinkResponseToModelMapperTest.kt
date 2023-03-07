package com.br.shortener_link.feature.shortUrl.data.mapper

import com.br.shortener_link.feature.shortUrl.data.datasource.api.dto.response.Links
import com.br.shortener_link.feature.shortUrl.data.mapper.mapToDomain
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