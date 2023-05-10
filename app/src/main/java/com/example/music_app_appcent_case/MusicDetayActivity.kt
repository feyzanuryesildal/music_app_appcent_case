package com.example.music_app_appcent_case

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.adapter.MusicDetayAdapter
import com.example.music_app_appcent_case.viewModel.MusicDetayViewModel
import kotlinx.coroutines.launch

class MusicDetayActivity : AppCompatActivity() {


    private lateinit var musicDetayViewModel: MusicDetayViewModel
    private lateinit var musicDetayRecyclerView: RecyclerView
    private lateinit var musicDetayAdapter: MusicDetayAdapter

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
        musicDetayViewModel = ViewModelProvider(this).get(MusicDetayViewModel::class.java)
        musicDetayViewModel.getMusicDetayApiData(gelenVeri3)

        musicDetayViewModel.productListData.observe(this) {
            musicDetayAdapter = MusicDetayAdapter(it)
            musicDetayRecyclerView.layoutManager = LinearLayoutManager(this)
            musicDetayRecyclerView.adapter = musicDetayAdapter

        }
    }

}