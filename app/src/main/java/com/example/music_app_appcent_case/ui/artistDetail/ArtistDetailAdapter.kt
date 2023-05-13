package com.example.music_app_appcent_case.ui.artistDetail

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.music_app_appcent_case.ui.musicDetail.MusicDetailActivity
import com.example.music_app_appcent_case.R
//import com.example.music_app_appcent_case.db.Like
//import com.example.music_app_appcent_case.db.LikeDao
//import com.example.music_app_appcent_case.db.LikeDatabase
import com.example.music_app_appcent_case.network.model.artistModel.ArtistModel
import com.example.music_app_appcent_case.network.model.artistModel.Data


class ArtistDetailAdapter(private val artistDetail: ArtistModel, private val context: Context) : RecyclerView.Adapter<ArtistDetailAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.artist_detay_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = artistDetail.data[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = artistDetail?.data?.size ?: 0 //?? size dönmüyor geri gelirken


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        private val productImageView: ImageView = itemView.findViewById(R.id.imageView3)
        private val artistName: TextView = itemView.findViewById(R.id.artistName)
        private val songsDate: TextView = itemView.findViewById(R.id.songsDate)
        private val card: CardView = itemView.findViewById(R.id.card_view_artist)
        //private val heartButton: ImageButton = itemView.findViewById(R.id.imageButtonKalp)
        private var isLiked = false

        val artistImageView = ImageView(context).findViewById<ImageView>(R.id.imageViewArtistDetayKapak)

        fun bind(artistDetailData: Data) {
            artistName.text = artistDetailData.title
            songsDate.text = artistDetailData.release_date

            Glide.with(productImageView.getContext())
                .load(artistDetailData.cover_medium)
                .into(productImageView)

            if(artistImageView != null){
                Glide.with(artistImageView.getContext())
                    .load(artistDetailData.cover_medium)
                    .into(artistImageView)
            }else{
                artistImageView?.setImageResource(R.drawable.kalpkirmizi)
            }




            productImageView.isClickable = true
            productImageView.setOnClickListener {
                val intent = Intent(itemView.context, MusicDetailActivity::class.java)
                intent.putExtra("album.id", artistDetailData.id)
                intent.putExtra("album.name", artistDetailData.title)
                intent.putExtra("album.picture", artistDetailData.cover_medium)
                itemView.context.startActivity(intent)
            }
            card.setOnClickListener {
                val intent = Intent(itemView.context, MusicDetailActivity::class.java)
                intent.putExtra("album.id", artistDetailData.id)
                intent.putExtra("album.name", artistDetailData.title)
                intent.putExtra("album.picture", artistDetailData.cover_medium)
                itemView.context.startActivity(intent)
            }
            /*
            heartButton.setOnClickListener {
                if (isLiked) {
                    heartButton.setImageResource(R.drawable.heart)
                    isLiked = false
                } else {
                    heartButton.setImageResource(R.drawable.heart_black)
                    isLiked = true
                }

            }*/

        }
    }
}