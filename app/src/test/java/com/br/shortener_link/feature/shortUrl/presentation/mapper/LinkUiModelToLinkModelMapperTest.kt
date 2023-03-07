package com.br.shortener_link.feature.shortUrl.presentation.mapper

import com.br.shortener_link.feature.shortUrl.domain.model.LinkModel
import com.br.shortener_link.feature.shortUrl.presentation.mapper.mapToPresentation
import junit.framework.TestCase.assertEquals
import org.junit.Test


class LinkUiModelToLinkModelMapperTest {

    @Test
    fun `should mapper links to link model`() {
        // given
        val expectedLinkModel = LinkModel(self = "self", short = "short")
        // when
        val actualLinkModel = expectedLinkModel.mapToPresentation()
        // then
        assertEquals(expectedLinkModel.self, actualLinkModel.self)
        assertEquals(expectedLinkModel.short, actualLinkModel.short)
    }
}