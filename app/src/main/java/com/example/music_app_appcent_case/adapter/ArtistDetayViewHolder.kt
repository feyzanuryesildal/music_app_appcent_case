package com.example.music_app_appcent_case.adapter

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.music_app_appcent_case.GenreDetayActivity
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.model.ItemModel

class ArtistDetayViewHolder (itemView : View): RecyclerView.ViewHolder(itemView) {

    fun bindItems(itemModel: ItemModel) {
        val image = itemView.findViewById(R.id.imageView4) as ImageView

        val name = itemView.findViewById(R.id.textView4) as TextView


        name.text = itemModel.description

        image.setImageResource(itemModel.image)

        image.isClickable = true
        image.setOnClickListener {
            Log.e("kontrol3","tıklandı") // çalıştı
            val intent = Intent(itemView.context, GenreDetayActivity::class.java)
            itemView.context.startActivity(intent)

        }
    }


}