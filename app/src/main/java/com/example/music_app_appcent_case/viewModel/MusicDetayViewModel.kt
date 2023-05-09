package com.example.music_app_appcent_case.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.music_app_appcent_case.model.modelMusic.MusicModel
import com.example.music_app_appcent_case.network.ArtistDetayRetrofitInstance
import com.example.music_app_appcent_case.network.MusicDetayRetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MusicDetayViewModel : ViewModel(){
    private val productList = MutableLiveData<MusicModel> ()
    val productListData: LiveData<MusicModel> get() = productList


    fun getMusicDetayApiData(id: Int){

        MusicDetayRetrofitInstance.getMusicDetayRetrofitInstance().getMusicDataFromApi(id).enqueue(object :
            Callback<MusicModel> {
            override fun onResponse(
                call: Call<MusicModel>,
                response: Response<MusicModel>
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

            override fun onFailure(call: Call<MusicModel>, t: Throwable) {
                Log.d("Service", "Failed: ${t.message}")

            }

        })

    }
}