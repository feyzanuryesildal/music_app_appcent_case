package com.example.music_app_appcent_case.adapter

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.GenreDetayActivity
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.model.ItemModel

class ItemListViewHolder (itemView : View): RecyclerView.ViewHolder(itemView) {

    fun bindItems(itemModel: ItemModel) {
        val image = itemView.findViewById(R.id.image) as ImageView

        image.setImageResource(itemModel.image)
        image.isClickable = true
        image.setOnClickListener {
            Log.e("kontrol","tıklandı") // çalıştı
            val intent = Intent(itemView.context, GenreDetayActivity::class.java)
            itemView.context.startActivity(intent)

        }
    }


}