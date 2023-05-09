package com.example.music_app_appcent_case

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.adapter.ArtistDetayAdapter
import com.example.music_app_appcent_case.adapter.GenreDetayAdapter
import com.example.music_app_appcent_case.model.ItemModel
import com.example.music_app_appcent_case.model.MockList

class ArtistDetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_detay)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        /*
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView3)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter =
            ArtistDetayAdapter(MockList.getMockedItemList() as ArrayList<ItemModel>)

        recyclerView.adapter= adapter*/
    }
}
