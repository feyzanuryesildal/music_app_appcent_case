package com.example.music_app_appcent_case.ui.musicDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.music_app_appcent_case.network.model.musicDetailModel.MusicDetailModel
import com.example.music_app_appcent_case.network.ApiInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MusicDetailViewModel : ViewModel(){
    private val musicDetailList = MutableLiveData<MusicDetailModel> ()
    val musicDetailListData: LiveData<MusicDetailModel> get() = musicDetailList


    fun getMusicDetayApiData(id: Int){
        ApiInstance.getRetrofitInstance().getMusicDataFromApi(id).enqueue(object :
            Callback<MusicDetailModel> {
            override fun onResponse(
                call: Call<MusicDetailModel>,
                response: Response<MusicDetailModel>
            ) {
                if (response.isSuccessful) {
                    Log.d("Service", "Succses Music Detail")
                    response.body()?.let {
                        Log.d("Service", "Body")
                        musicDetailList.postValue(it)
                    }?: kotlin.run {
                        Log.d("Service", "Empty Body")
                    }
                } else {
                    Log.d("Service", "Failed")
                }
            }

            override fun onFailure(call: Call<MusicDetailModel>, t: Throwable) {
                Log.d("Service", "Failed: ${t.message}")
            }
        })
    }
}