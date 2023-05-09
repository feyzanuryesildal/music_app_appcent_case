package com.example.music_app_appcent_case.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GenreDetayRetrofitInstance {

    fun getGenreDetayRetrofitInstance() : GenreDetayService{
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(GenreDetayService::class.java)

    }
}