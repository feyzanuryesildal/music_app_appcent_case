package com.example.music_app_appcent_case.ui.genreDetail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.R

class GenreDetailActivity : AppCompatActivity() {

    private lateinit var genreDetayViewModel: GenreDetailViewModel
    private lateinit var genreDetayRecyclerView: RecyclerView
    private lateinit var genreDetayAdapter: GenreDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre_detay)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setTitle("Sanatçılar")

        val gelenVeri = intent.getIntExtra("product.id", 0)
        if (gelenVeri != null) {
            Log.e("kontrol veri", "${gelenVeri}")
        } else {
            Log.e("kontrol veri", " null dönndü")
        }

        genreDetayRecyclerView = findViewById<RecyclerView>(R.id.recyclerView2)
        genreDetayRecyclerView.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        genreDetayViewModel = ViewModelProvider(this).get(GenreDetailViewModel::class.java)
        genreDetayViewModel.getGenreDetayApiData(gelenVeri)

        genreDetayViewModel.productListData.observe(this) {
            genreDetayAdapter = GenreDetailAdapter(it)
            //productsRecyclerView.layoutManager = LinearLayoutManager(this)
            genreDetayRecyclerView.adapter = genreDetayAdapter


            /*
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView2)
        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)

        val adapter =
            GenreDetayAdapter(MockList.getMockedItemList() as ArrayList<ItemModel>)

        recyclerView.adapter= adapter*/
        }


    }
}