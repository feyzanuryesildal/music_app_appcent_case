package com.example.music_app_appcent_case.network

import com.example.music_app_appcent_case.model.musicDetayModel.MusicDetayModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MusicService {
    @GET("album/{music_id}/tracks")
    fun getMusicDataFromApi(@Path("music_id") id: Int): Call<MusicDetayModel>
}