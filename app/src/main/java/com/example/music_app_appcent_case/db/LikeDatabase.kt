package com.example.music_app_appcent_case.db
/*
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Like::class],
    version = 1,
    exportSchema = false
)
abstract class LikeDatabase : RoomDatabase() {

    abstract fun getLikeDao(): LikeDao

    companion object {

        @Volatile
        private var instance: LikeDatabase? = null


        fun getDatabaseInstance(context: Context) : LikeDatabase {
            return instance ?: synchronized(this) {
                val newInstance = Room.databaseBuilder(
                    context,
                    LikeDatabase::class.java,
                    "note_database"
                ).build()
                instance = newInstance
                newInstance
            }
        }
    }
}*/