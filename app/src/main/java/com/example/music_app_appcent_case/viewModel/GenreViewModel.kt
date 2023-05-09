package com.example.music_app_appcent_case.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.music_app_appcent_case.model.GenreModel
import com.example.music_app_appcent_case.network.GenreRetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GenreViewModel : ViewModel(){
    //var ProductDataList = MutableLiveData<List<ProductsModel>>()
    /*val productList: MutableLiveData<List<ProductsModel>> by lazy {
        MutableLiveData<List<ProductsModel>>()
    }*/
    private val productList = MutableLiveData<GenreModel> ()
    val productListData: LiveData<GenreModel> get() = productList
    fun getApiData(){

        //val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(ProductService::class.java)
        GenreRetrofitInstance.getRetrofitInstance().getDataFromApi().enqueue(object :
            Callback<GenreModel> {
            override fun onResponse(
                call: Call<GenreModel>,
                response: Response<GenreModel>
            ) {
                if (response.isSuccessful) {
                    Log.d("Service", "Succses")
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

            override fun onFailure(call: Call<GenreModel>, t: Throwable) {
                Log.d("Service", "Failed: ${t.message}")

            }

        })

    }
}