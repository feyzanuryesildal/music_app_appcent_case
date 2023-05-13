package com.example.music_app_appcent_case.db

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface LikeDao {

    @Insert
     fun addLike(like: LikedSongs)

    @Delete
     fun deleteLike(like: LikedSongs)

    @Update
     fun updateLike(like: LikedSongs)

    @Query("Select * from $tableName order by id ASC")
    fun getAllLikes(): LiveData<List<LikedSongs>>

}