package com.example.music_app_appcent_case.ui


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.ui.genreList.GenreListAdapter
import com.example.music_app_appcent_case.databinding.ActivityMainBinding

import com.example.music_app_appcent_case.ui.likedList.LikedListFragment
import com.example.music_app_appcent_case.ui.genreList.GenreListFragment
import com.example.music_app_appcent_case.ui.genreList.GenreViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var genreViewModel: GenreViewModel
    private lateinit var genreRecyclerView: RecyclerView
    private lateinit var genreAdapter: GenreListAdapter
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("Kategoriler")



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(GenreListFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.MusicList -> replaceFragment(GenreListFragment())
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