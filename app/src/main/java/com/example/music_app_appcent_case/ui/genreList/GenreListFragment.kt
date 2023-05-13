package com.example.music_app_appcent_case.ui.genreList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.databinding.FragmentMusicGenreListBinding


class GenreListFragment : Fragment(R.layout.fragment_music_genre_list) {
    private lateinit var genreAdapter: GenreListAdapter

    private val viewModel: GenreViewModel by viewModels()

    private var binding: FragmentMusicGenreListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMusicGenreListBinding.bind(view)

        sendRequest()
        observeViewModel()

    }

    fun sendRequest(){
        viewModel.getApiData()
    }

    fun observeViewModel(){
        viewModel.genreListData.observe(viewLifecycleOwner){
            Log.d("xxxxxx",it.data.size.toString())
            genreAdapter = GenreListAdapter(it)
            binding?.fragmentRecyclerview?.adapter = genreAdapter
            //binding?.fragmentRecyclerview?.layoutManager = LinearLayoutManager(context)
            binding?.fragmentRecyclerview?.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            /*genreDetayRecyclerView.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)*/
        }

    }


}