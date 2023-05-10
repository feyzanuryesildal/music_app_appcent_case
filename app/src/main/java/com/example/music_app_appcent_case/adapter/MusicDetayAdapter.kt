package com.example.music_app_appcent_case.adapter

import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
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
        private val heartButton: ImageButton = itemView.findViewById(R.id.imageButtonKalp2)
        private var isLiked = false

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
                Log.e("kontrol", "muzik çaldı")
            }

            card.setOnClickListener {

                mediaPlayer.setDataSource(product.preview)
                mediaPlayer.prepare()
                mediaPlayer.start()
                Log.e("kontrol", "muzik çaldı")

            }
            /*
            heartButton.setOnClickListener {
                if (isLiked) {
                    heartButton.setImageResource(R.drawable.kalp)
                    Log.e("button", "tiklandi kalp")
                    isLiked = false
                    // Beğeni kaydını güncelle
                    GlobalScope.launch {
                        val like = mainActivity.db.likeDao()
                            .getLike(1) // 1 burada beğeni kaydının id'si olarak varsayılan olarak kullanılmıştır
                        like.isLiked = false
                        mainActivity.db.likeDao().insertLike(like)
                    }
                } else {
                    heartButton.setImageResource(R.drawable.kalpkirmizi)
                    Log.e("button", "tiklandi kirmizi kalp")
                    isLiked = true
                    // Beğeni kaydını güncelle
                    GlobalScope.launch {
                        val like = mainActivity.db.likeDao()
                            .getLike(1) // 1 burada beğeni kaydının id'si olarak varsayılan olarak kullanılmıştır
                        like.isLiked = true */




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