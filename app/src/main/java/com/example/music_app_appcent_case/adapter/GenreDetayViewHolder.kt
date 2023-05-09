package com.example.music_app_appcent_case.adapter

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.ArtistDetayActivity
import com.example.music_app_appcent_case.GenreDetayActivity
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.model.ItemModel

class GenreDetayViewHolder (itemView : View): RecyclerView.ViewHolder(itemView) {

    fun bindItems(itemModel: ItemModel) {
        val image2 = itemView.findViewById(R.id.image2) as ImageView

        image2.setImageResource(itemModel.image)
        image2.isClickable = true
        image2.setOnClickListener {
            Log.e("kontrol2","tıklandı") // çalıştı
            val intent = Intent(itemView.context, ArtistDetayActivity::class.java)
            itemView.context.startActivity(intent)

        }
    }


}