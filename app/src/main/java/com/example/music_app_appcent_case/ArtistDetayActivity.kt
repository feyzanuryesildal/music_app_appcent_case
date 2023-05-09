package com.example.music_app_appcent_case

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.adapter.AlbumGenreAdapter
import com.example.music_app_appcent_case.adapter.ArtistDetayAdapter
import com.example.music_app_appcent_case.adapter.GenreDetayAdapter
import com.example.music_app_appcent_case.model.ItemModel
import com.example.music_app_appcent_case.model.MockList
import com.example.music_app_appcent_case.viewModel.ArtistDetayViewModel
import com.example.music_app_appcent_case.viewModel.GenreDetayViewModel
import com.example.music_app_appcent_case.viewModel.GenreViewModel

class ArtistDetayActivity : AppCompatActivity() {

    private lateinit var artistDetayViewModel: ArtistDetayViewModel
    private lateinit var artistDetayRecyclerView: RecyclerView
    private lateinit var artistDetayAdapter: ArtistDetayAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_detay)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val gelenVeri2 = intent.getIntExtra("artist.id", 0)
        if (gelenVeri2 != null) {
            Log.e("kontrol veri", "${gelenVeri2}")
        } else {
            Log.e("kontrol veri", " null dönndü")
        }


        artistDetayRecyclerView = findViewById<RecyclerView>(R.id.recyclerView3)
       // artistDetayRecyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        artistDetayViewModel = ViewModelProvider(this).get(ArtistDetayViewModel::class.java)
        artistDetayViewModel.getArtistDetayApiData(gelenVeri2)

        artistDetayViewModel.productListData.observe(this){ artistDetayAdapter = ArtistDetayAdapter(it)
            artistDetayRecyclerView.layoutManager = LinearLayoutManager(this)
            artistDetayRecyclerView.adapter = artistDetayAdapter

        }
        /*
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView3)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter =
            ArtistDetayAdapter(MockList.getMockedItemList() as ArrayList<ItemModel>)

        recyclerView.adapter= adapter*/
    }
}
