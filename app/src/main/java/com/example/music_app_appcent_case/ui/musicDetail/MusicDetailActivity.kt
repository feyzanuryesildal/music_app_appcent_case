package com.example.music_app_appcent_case.ui.musicDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.db.LikeDatabase
import com.example.music_app_appcent_case.db.LikeRepository
import com.example.music_app_appcent_case.db.LikedSongs
import com.example.music_app_appcent_case.network.model.musicDetailModel.MusicDetailData
import com.example.music_app_appcent_case.ui.utils.RowClickListener
import kotlinx.coroutines.launch

class MusicDetailActivity : AppCompatActivity() {


    private lateinit var musicDetayViewModel: MusicDetailViewModel
    private lateinit var musicDetayRecyclerView: RecyclerView
    private lateinit var musicDetayAdapter: MusicDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_detay)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setTitle("Müzikler")

        //////
        /*val dao = LikeDatabase.getDatabaseInstance(this).getLikeDao()
        val repository = LikeRepository(dao)

        val note = Like(
            likeTitle = true
        )

        lifecycleScope.launch {
            repository.addNote(note)
        }

        repository.allLikes.observe(this) { noteList ->
            noteList.forEach {
                Log.d("Detail", it.likeTitle.toString())
            }}*/
        /////
        val gelenVeri3 = intent.getIntExtra("album.id", 0)
        if (gelenVeri3 != null) {
            Log.e("kontrol veri 3", "${gelenVeri3}")
        } else {
            Log.e("kontrol veri3", " null dönndü")
        }

        musicDetayRecyclerView = findViewById<RecyclerView>(R.id.recyclerView4)
        musicDetayViewModel = ViewModelProvider(this).get(MusicDetailViewModel::class.java)
        musicDetayViewModel.getMusicDetayApiData(gelenVeri3)



        val dao = LikeDatabase.getDatabaseInstance(this).getLikeDao()
        val repository = LikeRepository(dao)

        musicDetayViewModel.productListData.observe(this) {
            musicDetayAdapter = MusicDetailAdapter(it.data, object : RowClickListener<MusicDetailData> {
                override fun onRowClick(pos: Int, item: MusicDetailData) {
                    TODO("Not yet implemented")

                    lifecycleScope.launch {
                        val likedSongs = LikedSongs(
                            songId = item.id,
                            likeTitle = item.title,
                            songName = item.title_short,
                            songLong = item.duration,
                            songLink = item.preview
                        )
                        repository.addLike(likedSongs)
                    }
                    /*
                    repository.allLikes.observe(this) { likeList ->
                        likeList.forEach {
                            Log.d("Detail", it.songLink)
                        }
                    }*/

                }

            })
            musicDetayRecyclerView.layoutManager = LinearLayoutManager(this)
            musicDetayRecyclerView.adapter = musicDetayAdapter

        }
    }

}