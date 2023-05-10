package com.example.music_app_appcent_case


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.adapter.AlbumGenreAdapter
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