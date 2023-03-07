package com.br.shortener_link.feature.shortUrl.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.shortener_link.databinding.ViewItemShortUrlBinding
import com.br.shortener_link.feature.shortUrl.domain.model.ShortModel
import com.br.shortener_link.feature.shortUrl.presentation.model.ShortUiModel

class ShortUrlRecyclerViewAdapter :
    RecyclerView.Adapter<ShortUrlRecyclerViewAdapter.ViewHolder>() {

    private val shortUiModels = mutableListOf<ShortUiModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ViewItemShortUrlBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount() = shortUiModels.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(shortUiModels[position])
    }

    fun addItem(shortUiModel: ShortUiModel) {
        shortUiModels.add(shortUiModel)
    }

    inner class ViewHolder(private val viewItem: ViewItemShortUrlBinding) :
        RecyclerView.ViewHolder(viewItem.root) {
        fun bind(shortUiModel: ShortUiModel) {
            viewItem.shortUrlItemTitle.text = shortUiModel.alias
        }
    }
}