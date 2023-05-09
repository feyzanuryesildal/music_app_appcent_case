package com.example.music_app_appcent_case.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.music_app_appcent_case.ArtistDetayActivity
import com.example.music_app_appcent_case.GenreDetayActivity
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.model.Data
import com.example.music_app_appcent_case.model.GenreModel
import com.example.music_app_appcent_case.model.ItemModel

class GenreDetayAdapter (private val products: GenreModel) : RecyclerView.Adapter<GenreDetayAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.genre_detay_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.data[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = products.data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImageView: ImageView = itemView.findViewById(R.id.image2)
        private val artistName: TextView = itemView.findViewById(R.id.textView3)

        fun bind(product: Data) {
            artistName.text = product.name
            Glide.with(productImageView.getContext())
                .load(product.picture_medium)
                .into(productImageView)

            productImageView.isClickable = true
            productImageView.setOnClickListener {
                Log.e("kontrol","tıklandı") // çalıştı
                val intent = Intent(itemView.context, ArtistDetayActivity::class.java)
                intent.putExtra("artist.id", product.id)
                itemView.context.startActivity(intent)
                Log.e("kontrol",product.name)
                Log.e("kontrol","${product.id}")

            }

        }
    }
}