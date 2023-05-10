package com.example.music_app_appcent_case.adapter

import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.music_app_appcent_case.ArtistDetayActivity
import com.example.music_app_appcent_case.MusicDetayActivity
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.model.musicDetayModel.Data
import com.example.music_app_appcent_case.model.musicDetayModel.MusicDetayModel


class MusicDetayAdapter(private val products: MusicDetayModel) : RecyclerView.Adapter<MusicDetayAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.music_detay_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.data[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = products.data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImageView: ImageView = itemView.findViewById(R.id.imageViewMusic)
        private val artistName: TextView = itemView.findViewById(R.id.artistNameMusic)
        private val card: CardView = itemView.findViewById(R.id.card_view_music)

        fun bind(product: Data) {
            artistName.text = product.title
            /*Glide.with(productImageView.getContext())
                .load(product.md5_image)
                .into(productImageView)*/


            val mediaPlayer = MediaPlayer()


            productImageView.isClickable = true
            productImageView.setOnClickListener {
                mediaPlayer.setDataSource(product.preview)
                mediaPlayer.prepare()
                mediaPlayer.start()
                Log.e("kontrol","muzik çaldı")
            }

            card.setOnClickListener {

                mediaPlayer.setDataSource(product.preview)
                mediaPlayer.prepare()
                mediaPlayer.start()
                Log.e("kontrol","muzik çaldı")

            }

        }
    }
}