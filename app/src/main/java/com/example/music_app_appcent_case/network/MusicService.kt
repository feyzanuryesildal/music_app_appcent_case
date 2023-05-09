package com.example.music_app_appcent_case.network

import com.example.music_app_appcent_case.model.GenreModel
import com.example.music_app_appcent_case.model.modelMusic.MusicModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MusicService {
    @GET("album/{music_id}")
    fun getMusicDataFromApi(@Path("id") id: Int): Call<MusicModel>
}