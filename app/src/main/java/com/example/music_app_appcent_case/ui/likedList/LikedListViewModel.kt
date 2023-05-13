package com.example.music_app_appcent_case.ui.likedList

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.music_app_appcent_case.db.LikedSongs
import com.example.music_app_appcent_case.db.LikeDatabase
import com.example.music_app_appcent_case.db.LikeRepository

class LikedListViewModel : ViewModel() {

    private var repository: LikeRepository? = null
    //private lateinit var repositoryx: LikeRepository
    //private val likedList = MutableLiveData<List<Like>>()


    var likedListData: LiveData<List<LikedSongs>>? = null

    fun initDb(context: Context){
        val dao = LikeDatabase.getDatabaseInstance(context).getLikeDao()
        repository = LikeRepository(dao)

        likedListData = repository!!.allLikes


    }
}