package com.example.music_app_appcent_case.ui.genreList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.music_app_appcent_case.network.model.GenreModel
import com.example.music_app_appcent_case.network.ApiInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GenreViewModel : ViewModel(){
    private val genreList = MutableLiveData<GenreModel> ()
    val genreListData: LiveData<GenreModel> get() = genreList

    fun getApiData(){

        ApiInstance.getRetrofitInstance().getDataFromApi().enqueue(object :
            Callback<GenreModel> {
            override fun onResponse(
                call: Call<GenreModel>,
                response: Response<GenreModel>
            ) {
                if (response.isSuccessful) {
                    Log.d("Service", "Succses Genre ")
                    response.body()?.let {
                        Log.d("Service", "Body")
                        genreList.postValue(it)
                    }?: kotlin.run {
                        Log.d("Service", "Empty Body")
                    }
                } else {
                    Log.d("Service", "Failed")
                }

            }

            override fun onFailure(call: Call<GenreModel>, t: Throwable) {
                Log.d("Service", "Failed: ${t.message}")
            }
        })
    }
}