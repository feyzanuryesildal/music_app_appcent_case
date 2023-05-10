package com.example.music_app_appcent_case.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.music_app_appcent_case.model.model2.ArtistModel

import com.example.music_app_appcent_case.network.ArtistDetayRetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtistDetayViewModel : ViewModel(){
    private val productList = MutableLiveData<ArtistModel> ()
    val productListData: LiveData<ArtistModel> get() = productList


    fun getArtistDetayApiData(id: Int){

        ArtistDetayRetrofitInstance.getArtistDetayRetrofitInstance().getArtistDetayDataFromApi(id).enqueue(object :
            Callback<ArtistModel> {
            override fun onResponse(
                call: Call<ArtistModel>,
                response: Response<ArtistModel>
            ) {
                if (response.isSuccessful) {
                    Log.d("Service", "Succsesaaaaaaaaaaaaaaaaaa")
                    response.body()?.let {
                        Log.d("Service", "Body")
                        productList.postValue(it)
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