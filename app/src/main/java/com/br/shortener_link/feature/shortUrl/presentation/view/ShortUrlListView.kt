package com.br.shortener_link.feature.shortUrl.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.shortener_link.databinding.ViewShortUrlListBinding
import com.br.shortener_link.feature.shortUrl.presentation.adapter.ShortUrlRecyclerViewAdapter
import com.br.shortener_link.feature.shortUrl.presentation.model.ShortUiModel

class ShortUrlListView(
    context: Context,
    attrs: AttributeSet
) : FrameLayout(context, attrs) {

    private val viewBind =
        ViewShortUrlListBinding.inflate(LayoutInflater.from(context), this, true)
    private val shortUrlList = viewBind.shortUrlList
    private val adapter = ShortUrlRecyclerViewAdapter()

    fun setUpView() {
        shortUrlList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@ShortUrlListView.adapter
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    fun addItem(shortUiModel: ShortUiModel) = adapter.addItem(shortUiModel)
}