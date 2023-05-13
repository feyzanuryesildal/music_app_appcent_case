package com.example.music_app_appcent_case.ui.artistDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.music_app_appcent_case.network.model.artistModel.ArtistModel
import com.example.music_app_appcent_case.network.ApiInstance

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtistDetailViewModel : ViewModel(){
    private val artistDetailList = MutableLiveData<ArtistModel> ()
    val artistDetailListData: LiveData<ArtistModel> get() = artistDetailList

    fun getArtistDetayApiData(id: Int){
        ApiInstance.getRetrofitInstance().getArtistDetayDataFromApi(id).enqueue(object :
            Callback<ArtistModel> {
            override fun onResponse(
                call: Call<ArtistModel>,
                response: Response<ArtistModel>
            ) {
                if (response.isSuccessful) {
                    Log.d("Service", "Succses Artist Detail")
                    response.body()?.let {
                        Log.d("Service", "Body")
                        artistDetailList.postValue(it)
                    }?: kotlin.run {
                        Log.d("Service", "Empty Body")
                    }
                } else {
                    Log.d("Service", "Failed")
                }
            }
            override fun onFailure(call: Call<ArtistModel>, t: Throwable) {
                Log.d("Service", "Failed: ${t.message}")

            }
        })
    }
}