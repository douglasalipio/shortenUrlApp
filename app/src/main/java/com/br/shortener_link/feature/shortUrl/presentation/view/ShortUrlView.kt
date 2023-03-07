package com.br.shortener_link.feature.shortUrl.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.br.shortener_link.databinding.ViewShortUrlBinding

class ShortUrlView(
    context: Context,
    attrs: AttributeSet
) : FrameLayout(context, attrs) {

    private val viewBind = ViewShortUrlBinding.inflate(LayoutInflater.from(context), this, true)

    private fun getUrlString() = viewBind.urlStringText.text.toString()

    fun setOnclickListener(onSaveUrlActionClick: (String) -> Unit) {
        viewBind.saveUrlStringButton.setOnClickListener{onSaveUrlActionClick(getUrlString())}
    }

}