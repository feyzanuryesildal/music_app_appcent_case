package com.example.music_app_appcent_case.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = tableName)

class LikedSongs(
    @ColumnInfo(name = "songId") val songId: Int,
    @ColumnInfo(name = "likeTitle") val likeTitle: String,
    @ColumnInfo(name = "songName") val songName: String,
    @ColumnInfo(name = "songLong") val songLong: Int,
    @ColumnInfo(name = "songLink") val songLink: String,

    ) {
    @PrimaryKey(autoGenerate = true) var id = 0
}