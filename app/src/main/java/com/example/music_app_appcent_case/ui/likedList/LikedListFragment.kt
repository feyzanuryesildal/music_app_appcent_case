package com.example.music_app_appcent_case.ui.likedList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.databinding.FragmentMusicGenreListBinding


class LikedListFragment : Fragment() {
    private lateinit var likedListAdapter: LikedListAdapter

    private var binding: FragmentMusicGenreListBinding? = null

    private val viewModel: LikedListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liked_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMusicGenreListBinding.bind(view)

        sendRequest()
        observeViewModel()

    }

    fun sendRequest(){
        context?.let { viewModel.initDb(it.applicationContext) } //?????
    }

    fun observeViewModel(){
        viewModel.likedListData?.observe(viewLifecycleOwner){
            likedListAdapter = LikedListAdapter(it)
            binding?.fragmentRecyclerview?.adapter = likedListAdapter
            binding?.fragmentRecyclerview?.layoutManager = LinearLayoutManager(context)
        }
    }
}