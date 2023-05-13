package com.example.music_app_appcent_case.ui.genreList
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.music_app_appcent_case.ui.genreDetail.GenreDetailActivity
import com.example.music_app_appcent_case.R
import com.example.music_app_appcent_case.network.model.Data
import com.example.music_app_appcent_case.network.model.GenreModel

class GenreListAdapter (private val genre: GenreModel) : RecyclerView.Adapter<GenreListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_genre_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = genre.data[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = genre.data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val genreNameTextView: TextView = itemView.findViewById(R.id.genreTextView)
        private val genreImageView: ImageView = itemView.findViewById(R.id.image)

        fun bind(genreData: Data) {
            genreNameTextView.text = genreData.name

            Glide.with(genreImageView.getContext())
                .load(genreData.picture_medium)
                .into(genreImageView)

            genreImageView.isClickable = true
            genreImageView.setOnClickListener {
                Log.e("kontrol","tıklandı") // çalıştı
                val intent = Intent(itemView.context, GenreDetailActivity::class.java)
                intent.putExtra("product.id", genreData.id)
                itemView.context.startActivity(intent)
                Log.e("kontrol",genreData.name)
                Log.e("kontrol","${genreData.id}")

            }

        }
    }
}

