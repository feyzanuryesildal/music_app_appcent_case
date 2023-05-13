package com.example.music_app_appcent_case.ui.artistDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.music_app_appcent_case.R

class ArtistDetailActivity : AppCompatActivity() {

    private lateinit var artistDetayViewModel: ArtistDetailViewModel
    private lateinit var artistDetayRecyclerView: RecyclerView
    private lateinit var artistDetayAdapter: ArtistDetailAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_detay)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val gelenVeriArtistDetail = intent.getIntExtra("artist.id", 0)
        val artistDetailName = intent.getStringExtra("artist.name")
        setTitle("${artistDetailName}")
        val pictureArtist = intent.getStringExtra("picture_medium")

        artistDetayRecyclerView = findViewById<RecyclerView>(R.id.recyclerView3)
       // artistDetayRecyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        artistDetayViewModel = ViewModelProvider(this).get(ArtistDetailViewModel::class.java)
        artistDetayViewModel.getArtistDetayApiData(gelenVeriArtistDetail)

        artistDetayViewModel.artistDetailListData.observe(this){ artistDetayAdapter = ArtistDetailAdapter(it,this)
            artistDetayRecyclerView.layoutManager = LinearLayoutManager(this)
            artistDetayRecyclerView.adapter = artistDetayAdapter

        }

        val imageView = findViewById<ImageView>(R.id.imageViewArtistDetayKapak)
        Glide.with(imageView.getContext())
            .load(pictureArtist)
            .into(imageView)
        /*
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView3)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter =
            ArtistDetayAdapter(MockList.getMockedItemList() as ArrayList<ItemModel>)

        recyclerView.adapter= adapter*/
    }
}
