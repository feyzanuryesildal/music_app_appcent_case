package com.example.music_app_appcent_case

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.adapter.AlbumGenreAdapter
import com.example.music_app_appcent_case.adapter.GenreDetayAdapter
import com.example.music_app_appcent_case.model.ItemModel
import com.example.music_app_appcent_case.model.MockList

class GenreDetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre_detay)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView2)
        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)

        val adapter =
            GenreDetayAdapter(MockList.getMockedItemList() as ArrayList<ItemModel>)

        recyclerView.adapter= adapter
    }


}