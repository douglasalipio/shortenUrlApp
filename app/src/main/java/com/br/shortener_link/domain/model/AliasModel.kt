package com.br.shortener_link.domain.model

data class AliasModel(
    val alias: String,
    val link: LinkModel
)