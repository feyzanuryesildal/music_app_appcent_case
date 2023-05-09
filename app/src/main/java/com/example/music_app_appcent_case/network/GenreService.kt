package com.example.music_app_appcent_case.network

import com.example.music_app_appcent_case.model.GenreModel
import retrofit2.Call
import retrofit2.http.GET

interface GenreService {

    @GET("genre")
    fun getDataFromApi(): Call<GenreModel>
}