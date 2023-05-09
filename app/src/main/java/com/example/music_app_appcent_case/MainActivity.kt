package com.example.music_app_appcent_case

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.adapter.AlbumGenreAdapter
import com.example.music_app_appcent_case.model.ItemModel
import com.example.music_app_appcent_case.model.MockList
import com.example.music_app_appcent_case.viewModel.GenreViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var genreViewModel: GenreViewModel
    private lateinit var genreRecyclerView: RecyclerView
    private lateinit var genreAdapter: AlbumGenreAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("Kategoriler")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        genreRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        genreRecyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        genreViewModel = ViewModelProvider(this).get(GenreViewModel::class.java)
        genreViewModel.getApiData()

        genreViewModel.productListData.observe(this){
            genreAdapter = AlbumGenreAdapter(it)
            //productsRecyclerView.layoutManager = LinearLayoutManager(this)
            genreRecyclerView.adapter = genreAdapter

        }



    }
}