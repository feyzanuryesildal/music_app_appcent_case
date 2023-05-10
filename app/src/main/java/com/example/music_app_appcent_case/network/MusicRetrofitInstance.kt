package com.example.music_app_appcent_case.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MusicDetayRetrofitInstance {
    /*fun getMusicDetayRetrofitInstance() : MusicService {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(MusicService::class.java)

    }*/

    fun getMusicDetayRetrofitInstance() : MusicService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MusicService::class.java)
    }

}