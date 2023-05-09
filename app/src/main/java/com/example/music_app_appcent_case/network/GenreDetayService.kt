package com.example.music_app_appcent_case.network

import com.example.music_app_appcent_case.model.GenreModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GenreDetayService{
    @GET("genre/{id}/artists")
    fun getGenreDetayDataFromApi(@Path("id") id: Int): Call<GenreModel>
}