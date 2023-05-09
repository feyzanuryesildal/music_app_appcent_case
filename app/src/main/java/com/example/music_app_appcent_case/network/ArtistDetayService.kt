package com.example.music_app_appcent_case.network

import com.example.music_app_appcent_case.model.model2.ArtistModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ArtistDetayService {
    @GET("artist/{artist_id}/albums")
    fun getArtistDetayDataFromApi(@Path("artist_id") id: Int): Call<ArtistModel>
}