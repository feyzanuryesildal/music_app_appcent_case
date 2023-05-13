package com.example.music_app_appcent_case.ui.artistDetail

import android.content.Context
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
import com.example.music_app_appcent_case.ui.musicDetail.MusicDetailActivity
import com.example.music_app_appcent_case.R
//import com.example.music_app_appcent_case.db.Like
//import com.example.music_app_appcent_case.db.LikeDao
//import com.example.music_app_appcent_case.db.LikeDatabase
import com.example.music_app_appcent_case.network.model.artistModel.ArtistModel
import com.example.music_app_appcent_case.network.model.artistModel.Data
import androidx.lifecycle.lifecycleScope


class ArtistDetailAdapter (private val products: ArtistModel, private val context: Context) : RecyclerView.Adapter<ArtistDetailAdapter.ViewHolder>() {

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

        val artistImageView = ImageView(context).findViewById<ImageView>(R.id.imageViewArtistDetayKapak)

        fun bind(product: Data) {
            artistName.text = product.title
            Glide.with(productImageView.getContext())
                .load(product.cover_medium)
                .into(productImageView)
            if(artistImageView != null){
                Glide.with(artistImageView.getContext())
                    .load(product.cover_medium)
                    .into(artistImageView)
            }else{
                artistImageView?.setImageResource(R.drawable.kalpkirmizi)
            }




            productImageView.isClickable = true
            productImageView.setOnClickListener {
                Log.e("kontrol","tıklandı33") // çalıştı
                val intent = Intent(itemView.context, MusicDetailActivity::class.java)
                intent.putExtra("album.id", product.id)
                itemView.context.startActivity(intent)

                Log.e("kontrol","${product.id}")

            }
            card.setOnClickListener {
                Log.e("kontrol","tıklandı33") // çalıştı
                val intent = Intent(itemView.context, MusicDetailActivity::class.java)
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

                ////////////


                //val likeDao = LikeDatabase.getDatabaseInstance(context).getLikeDao()

                // Beğeni durumunu Room veritabanına ekle
                //val like = Like(isLiked)
                //likeDao.addLike(like = like)




                heartButton.setOnClickListener {
                    if (isLiked) {
                        heartButton.setImageResource(R.drawable.kalp)
                        Log.e("button","tiklandi kalp")
                        isLiked = false

                        // Room database'inde beğenme durumunu güncelle
                        //val updatedLike = Like(isLiked, false)
                        //likeDao.updateLike(updatedLike)
                    } else {
                        heartButton.setImageResource(R.drawable.kalpkirmizi)
                        Log.e("button","tiklandi kirmizi kalp")
                        isLiked = true

                        // Room database'inde beğenme durumunu güncelle
                        //val updatedLike = Like(isLiked, true)
                        //likeDao.updateLike(updatedLike)
                    }
                }


                ////////////////////

            }

        }
    }
}