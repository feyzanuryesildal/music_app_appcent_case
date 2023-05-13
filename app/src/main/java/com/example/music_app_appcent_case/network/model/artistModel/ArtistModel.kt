package com.example.music_app_appcent_case.network.model.artistModel

data class ArtistModel(
    val `data`: List<Data>,
    val next: String,
    val total: Int
)