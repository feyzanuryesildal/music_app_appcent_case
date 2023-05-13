package com.example.music_app_appcent_case.db

import androidx.lifecycle.LiveData

class LikeRepository (private val likeDao: LikeDao) {

    suspend fun addLike(like: LikedSongs) {
        likeDao.addLike(like)
    }

    suspend fun deleteLike(like: LikedSongs) {
        likeDao.deleteLike(like)
    }

    suspend fun updateLike(note: LikedSongs) {
        likeDao.updateLike(note)
    }

    val allLikes: LiveData<List<LikedSongs>> = likeDao.getAllLikes()

}
