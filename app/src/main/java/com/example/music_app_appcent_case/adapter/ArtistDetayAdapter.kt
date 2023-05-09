package com.example.music_app_appcent_case.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.model.ItemModel

class ArtistDetayAdapter (val itemList: ArrayList<ItemModel>) :
    RecyclerView.Adapter<ArtistDetayViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistDetayViewHolder {
            return ArtistDetayViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.artist_detay_item,
                    parent,
                    false
                )
            )
        }

        override fun getItemCount(): Int {
            return itemList.size
        }

        override fun onBindViewHolder(holder: ArtistDetayViewHolder, position: Int) {
            holder.bindItems(itemList[position])

        }
    }
