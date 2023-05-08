package com.example.music_app_appcent_case

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.adapter.AlbumGenreAdapter
import com.example.music_app_appcent_case.model.ItemModel
import com.example.music_app_appcent_case.model.MockList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)

        val adapter =
            AlbumGenreAdapter(MockList.getMockedItemList() as ArrayList<ItemModel>)

        recyclerView.adapter= adapter

    }
}