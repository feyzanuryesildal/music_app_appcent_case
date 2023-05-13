package com.example.music_app_appcent_case.ui.genreDetail

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.music_app_appcent_case.ui.artistDetail.ArtistDetailActivity
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.network.model.Data
import com.example.music_app_appcent_case.network.model.GenreModel

class GenreDetailAdapter (private val genreDetail: GenreModel) : RecyclerView.Adapter<GenreDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.genre_detay_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = genreDetail.data[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = genreDetail.data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val genreImageView: ImageView = itemView.findViewById(R.id.image2)
        private val artistName: TextView = itemView.findViewById(R.id.textView3)

        fun bind(genreDetailData: Data) {
            artistName.text = genreDetailData.name
            Glide.with(genreImageView.getContext())
                .load(genreDetailData.picture_medium)
                .into(genreImageView)

            genreImageView.isClickable = true
            genreImageView.setOnClickListener {
                val intent = Intent(itemView.context, ArtistDetailActivity::class.java)
                intent.putExtra("artist.id", genreDetailData.id)
                itemView.context.startActivity(intent)
            }

        }
    }
}