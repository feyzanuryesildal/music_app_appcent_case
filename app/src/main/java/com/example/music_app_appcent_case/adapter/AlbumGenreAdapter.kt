package com.example.music_app_appcent_case.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView
import androidx.appcompat.widget.AppCompatTextView
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.model.ItemModel

class AlbumGenreAdapter (val itemList: ArrayList<ItemModel>) :
    RecyclerView.Adapter<ItemListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        return ItemListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.album_genre_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        holder.bindItems(itemList[position])


    }
}


