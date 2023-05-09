package com.example.music_app_appcent_case

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MusicDetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_detay)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val gelenVeri3 = intent.getIntExtra("album.id", 0)
        if (gelenVeri3 != null) {
            Log.e("kontrol veri 3", "${gelenVeri3}")
        } else {
            Log.e("kontrol veri3", " null dönndü")
        }
    }
}