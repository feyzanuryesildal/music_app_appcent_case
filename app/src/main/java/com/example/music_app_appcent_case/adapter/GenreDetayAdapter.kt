package com.example.music_app_appcent_case.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.model.ItemModel

class GenreDetayAdapter (val itemList: ArrayList<ItemModel>) :
    RecyclerView.Adapter<GenreDetayViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreDetayViewHolder {
        return GenreDetayViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.genre_detay_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: GenreDetayViewHolder, position: Int) {
        holder.bindItems(itemList[position])

    }
}