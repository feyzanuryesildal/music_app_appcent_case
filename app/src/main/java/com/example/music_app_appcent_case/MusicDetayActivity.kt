package com.example.music_app_appcent_case

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.adapter.MusicDetayAdapter
import com.example.music_app_appcent_case.viewModel.MusicDetayViewModel

class MusicDetayActivity : AppCompatActivity() {


    private lateinit var musicDetayViewModel: MusicDetayViewModel
    private lateinit var musicDetayRecyclerView: RecyclerView
    private lateinit var musicDetayAdapter: MusicDetayAdapter
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

        musicDetayRecyclerView = findViewById<RecyclerView>(R.id.recyclerView4)
        //musicDetayRecyclerView.layoutManager =
        //  GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        musicDetayViewModel = ViewModelProvider(this).get(MusicDetayViewModel::class.java)
        musicDetayViewModel.getMusicDetayApiData(gelenVeri3)

        musicDetayViewModel.productListData.observe(this) {
            musicDetayAdapter = MusicDetayAdapter(it)
            musicDetayRecyclerView.layoutManager = LinearLayoutManager(this)
            musicDetayRecyclerView.adapter = musicDetayAdapter


            /*artistDetayRecyclerView = findViewById<RecyclerView>(R.id.recyclerView3)
       // artistDetayRecyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        artistDetayViewModel = ViewModelProvider(this).get(ArtistDetayViewModel::class.java)
        artistDetayViewModel.getArtistDetayApiData(gelenVeri2)

        artistDetayViewModel.productListData.observe(this){ artistDetayAdapter = ArtistDetayAdapter(it)
            artistDetayRecyclerView.layoutManager = LinearLayoutManager(this)
            artistDetayRecyclerView.adapter = artistDetayAdapter*/
        }
    }

}