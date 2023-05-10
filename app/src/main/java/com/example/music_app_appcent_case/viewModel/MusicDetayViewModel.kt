package com.example.music_app_appcent_case.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.music_app_appcent_case.model.musicDetayModel.MusicDetayModel
import com.example.music_app_appcent_case.network.MusicDetayRetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MusicDetayViewModel : ViewModel(){
    private val productList = MutableLiveData<MusicDetayModel> ()
    val productListData: LiveData<MusicDetayModel> get() = productList


    fun getMusicDetayApiData(id: Int){

        MusicDetayRetrofitInstance.getMusicDetayRetrofitInstance().getMusicDataFromApi(id).enqueue(object :
            Callback<MusicDetayModel> {
            override fun onResponse(
                call: Call<MusicDetayModel>,
                response: Response<MusicDetayModel>
            ) {
                if (response.isSuccessful) {
                    Log.d("Service", "Succses music detay")
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

            override fun onFailure(call: Call<MusicDetayModel>, t: Throwable) {
                Log.d("Service", "Failed: ${t.message}")

            }

        })

    }
}