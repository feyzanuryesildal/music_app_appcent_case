package com.example.music_app_appcent_case.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.music_app_appcent_case.ArtistDetayActivity
import com.example.music_app_appcent_case.MusicDetayActivity
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.model.model2.ArtistModel
import com.example.music_app_appcent_case.model.model2.Data


class ArtistDetayAdapter (private val products: ArtistModel) : RecyclerView.Adapter<ArtistDetayAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.artist_detay_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.data[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = products.data.size




    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImageView: ImageView = itemView.findViewById(R.id.imageView3)
        //private val ImageView: ImageView = itemView.findViewById(R.id.imageViewAristDetay)
        private val artistName: TextView = itemView.findViewById(R.id.artistName)
        private val card: CardView = itemView.findViewById(R.id.card_view_artist)
        private val heartButton: ImageButton = itemView.findViewById(R.id.imageButtonKalp)
        private var isLiked = false

        fun bind(product: Data) {
            artistName.text = product.title
            Glide.with(productImageView.getContext())
                .load(product.cover_medium)
                .into(productImageView)



            productImageView.isClickable = true
            productImageView.setOnClickListener {
                Log.e("kontrol","tıklandı33") // çalıştı
                val intent = Intent(itemView.context, MusicDetayActivity::class.java)
                intent.putExtra("album.id", product.id)
                itemView.context.startActivity(intent)

                Log.e("kontrol","${product.id}")

            }
            card.setOnClickListener {
                Log.e("kontrol","tıklandı33") // çalıştı
                val intent = Intent(itemView.context, MusicDetayActivity::class.java)
                intent.putExtra("album.id", product.id)
                itemView.context.startActivity(intent)

                Log.e("kontrol","${product.id}")

            }

            heartButton.setOnClickListener {
                if (isLiked) {
                    heartButton.setImageResource(R.drawable.kalp)
                    Log.e("button","tiklandi kalp")
                    isLiked = false
                } else {
                    heartButton.setImageResource(R.drawable.kalpkirmizi)
                    Log.e("button","tiklandi kirmizi kalp")
                    isLiked = true
                }


            }

        }
    }
}