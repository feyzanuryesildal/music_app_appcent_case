package com.example.music_app_appcent_case.ui.musicDetail

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
import com.example.music_app_appcent_case.network.model.musicDetailModel.MusicDetailData
import com.example.music_app_appcent_case.ui.utils.RowClickListener

class MusicDetailAdapter(
    private val musicList: List<MusicDetailData>,
    private val heartClickListener: RowClickListener<MusicDetailData>) : RecyclerView.Adapter<MusicDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.music_detay_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = musicList[position]
        holder.bind(product, heartClickListener, position)
    }

    override fun getItemCount(): Int = musicList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val musicDetailImageView: ImageView = itemView.findViewById(R.id.imageViewMusic)
        private val artistName: TextView = itemView.findViewById(R.id.artistNameMusic)
        private val card: CardView = itemView.findViewById(R.id.card_view_music)
        private val heartButton: ImageButton = itemView.findViewById(R.id.imageButton2)
        private var isLiked = false

        fun bind(
            music: MusicDetailData,
            heartClickListener: RowClickListener<MusicDetailData>,
            position: Int
        ) {
            artistName.text = music.title
            heartButton.setOnClickListener{
                heartClickListener.onRowClick(position,music)
            }

            /*Glide.with(productImageView.getContext())
                .load(product.md5_image)
                .into(productImageView)*/

            val mediaPlayer = MediaPlayer()

            musicDetailImageView.isClickable = true
            musicDetailImageView.setOnClickListener {
                mediaPlayer.setDataSource(music.preview)
                mediaPlayer.prepare()
                mediaPlayer.start()
                Log.d("kontrol", "muzik çaldı")
            }

            card.setOnClickListener {
                mediaPlayer.setDataSource(music.preview)
                mediaPlayer.prepare()
                mediaPlayer.start()
                Log.d("kontrol", "muzik çaldı")
            }


            heartButton.setOnClickListener {
            if (isLiked) {
                heartButton.setImageResource(R.drawable.heart)
                isLiked = false
            } else {
                heartButton.setImageResource(R.drawable.heart_black)
                isLiked = true
            }
            }
        }
    }
}