package com.example.music_app_appcent_case.fragmentView

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.adapter.AlbumGenreAdapter
import com.example.music_app_appcent_case.databinding.FragmentMusicGenreListBinding
import com.example.music_app_appcent_case.viewModel.GenreViewModel


class MusicGenreListFragment : Fragment(R.layout.fragment_music_genre_list) {
    private lateinit var genreViewModel: GenreViewModel
    private lateinit var genreRecyclerView: RecyclerView
    private lateinit var genreAdapter: AlbumGenreAdapter

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
        viewModel.productListData.observe(viewLifecycleOwner){
            Log.d("xxxxxx",it.data.size.toString())
            genreAdapter = AlbumGenreAdapter(it)
            binding?.fragmentRecyclerview?.adapter = genreAdapter
            binding?.fragmentRecyclerview?.layoutManager = LinearLayoutManager(context)
        }

    }


}