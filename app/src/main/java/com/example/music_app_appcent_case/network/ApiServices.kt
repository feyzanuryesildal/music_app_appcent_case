package com.example.music_app_appcent_case.network

import com.example.music_app_appcent_case.network.model.GenreModel
import com.example.music_app_appcent_case.network.model.artistModel.ArtistModel
import com.example.music_app_appcent_case.network.model.musicDetailModel.MusicDetailModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET("artist/{artist_id}/albums")
    fun getArtistDetayDataFromApi(@Path("artist_id") id: Int): Call<ArtistModel>

    @GET("album/{music_id}/tracks")
    fun getMusicDataFromApi(@Path("music_id") id: Int): Call<MusicDetailModel>

    @GET("genre")
    fun getDataFromApi(): Call<GenreModel>

    @GET("genre/{id}/artists")
    fun getGenreDetayDataFromApi(@Path("id") id: Int): Call<GenreModel>


}