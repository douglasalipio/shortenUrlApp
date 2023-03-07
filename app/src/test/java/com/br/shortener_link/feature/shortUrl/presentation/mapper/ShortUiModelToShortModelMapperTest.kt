package com.br.shortener_link.feature.shortUrl.presentation.mapper

import com.br.shortener_link.feature.shortUrl.domain.model.LinkModel
import com.br.shortener_link.feature.shortUrl.domain.model.ShortModel
import com.br.shortener_link.feature.shortUrl.presentation.mapper.mapToPresentation
import junit.framework.TestCase.assertEquals
import org.junit.Test


class ShortUiModelToShortModelMapperTest {

    @Test
    fun `should mapper links to link model`() {
        // given
        val expectedShortModel = ShortModel("alias", LinkModel("self", "short"))
        // when
        val actualShortUiModel = expectedShortModel.mapToPresentation()
        // then
        assertEquals(expectedShortModel.alias, actualShortUiModel.alias)
        assertEquals(expectedShortModel.link.short, actualShortUiModel.link.short)
        assertEquals(expectedShortModel.link.self, actualShortUiModel.link.self)
    }
}