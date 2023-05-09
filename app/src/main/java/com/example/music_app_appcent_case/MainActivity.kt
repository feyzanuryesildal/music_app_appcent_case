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
    private lateinit var productViewModel: GenreViewModel
    private lateinit var productsRecyclerView: RecyclerView
    private lateinit var productsAdapter: AlbumGenreAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("Kategori")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)

        val adapter =
            AlbumGenreAdapter(MockList.getMockedItemList() as ArrayList<ItemModel>)

        recyclerView.adapter= adapter */

        productsRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        productsRecyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        productViewModel = ViewModelProvider(this).get(GenreViewModel::class.java)
        productViewModel.getApiData()

        productViewModel.productListData.observe(this){
            productsAdapter = AlbumGenreAdapter(it)
            //productsRecyclerView.layoutManager = LinearLayoutManager(this)
            productsRecyclerView.adapter = productsAdapter

        }



    }
}