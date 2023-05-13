package com.example.music_app_appcent_case.ui.musicDetail

import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.network.model.musicDetailModel.MusicDetailData
import com.example.music_app_appcent_case.ui.utils.RowClickListener

class MusicDetailAdapter(
    private val picture: String?,
    private val musicList: List<MusicDetailData>,
    private val heartClickListener: RowClickListener<MusicDetailData>) : RecyclerView.Adapter<MusicDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.music_detay_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = musicList[position]
        holder.bind(product, heartClickListener, position,picture)
    }

    override fun getItemCount(): Int = musicList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val musicDetailImageView: ImageView = itemView.findViewById(R.id.imageViewMusic)
        private val artistName: TextView = itemView.findViewById(R.id.artistNameMusic)
        private val musicLong: TextView = itemView.findViewById(R.id.musicLong)
        private val card: CardView = itemView.findViewById(R.id.card_view_music)
        private val heartButton: ImageButton = itemView.findViewById(R.id.imageButton2)
        private var isLiked = false

        fun bind(
            music: MusicDetailData,
            heartClickListener: RowClickListener<MusicDetailData>,
            position: Int,
            picture: String?
        ) {
            artistName.text = music.title
            musicLong.text = music.duration.toString()
            heartButton.setOnClickListener{
                heartClickListener.onRowClick(position,music)
            }

            // albüm resmini resimlere koyar
            Glide.with(musicDetailImageView.getContext())
                .load(picture)
                .into(musicDetailImageView)

            val mediaPlayer = MediaPlayer()

            musicDetailImageView.isClickable = true
            musicDetailImageView.setOnClickListener {
                mediaPlayer.setDataSource(music.preview)
                mediaPlayer.prepare()
                mediaPlayer.start()
                Log.d("kontrol", "muzik çaldı")
            }

            /*
            musicDetailImageView.setImageResource(R.drawable.play)
            musicDetailImageView.setOnClickListener {
                musicDetailImageView.setImageResource(R.drawable.pause)
                mediaPlayer.setDataSource(music.preview)
                mediaPlayer.prepare()
                mediaPlayer.start()
                Log.d("kontrol", "muzik çaldı")
                // Start a countdown timer for 30 seconds
                object : CountDownTimer(30000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        // Do nothing
                        mediaPlayer.stop()
                    }

                    override fun onFinish() {
                        // Change back to original drawable
                        musicDetailImageView.setImageResource(R.drawable.play)
                    }
                }.start()
            }*/

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