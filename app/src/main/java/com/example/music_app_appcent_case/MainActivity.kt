package com.example.music_app_appcent_case


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.adapter.AlbumGenreAdapter
import com.example.music_app_appcent_case.databinding.ActivityMainBinding

import com.example.music_app_appcent_case.fragmentView.LikedListFragment
import com.example.music_app_appcent_case.fragmentView.MusicGenreListFragment
import com.example.music_app_appcent_case.viewModel.GenreViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var genreViewModel: GenreViewModel
    private lateinit var genreRecyclerView: RecyclerView
    private lateinit var genreAdapter: AlbumGenreAdapter
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("Kategoriler")



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(MusicGenreListFragment())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.MusicList -> replaceFragment(MusicGenreListFragment())
                R.id.LikedList -> replaceFragment(LikedListFragment())
                else -> {


                }

            }

            true

        }


        }



    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }

}