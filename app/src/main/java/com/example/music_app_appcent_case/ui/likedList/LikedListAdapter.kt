package com.example.music_app_appcent_case.ui.likedList

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
import com.example.music_app_appcent_case.db.LikedSongs

class LikedListAdapter(private val products: List<LikedSongs>) : RecyclerView.Adapter<LikedListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_music_genre_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.listIterator()
        holder.bind(product)
    }

    override fun getItemCount(): Int = products.size

     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImageView: ImageView = itemView.findViewById(R.id.imageViewLikedList)
        private val artistName: TextView = itemView.findViewById(R.id.artistNameLikedList)
        private val card: CardView = itemView.findViewById(R.id.card_view_liked_list)
        private val heartButton: ImageButton = itemView.findViewById(R.id.imageButtonKalp2)
        private var isLiked = false

        fun bind(product: ListIterator<LikedSongs>) {
            //artistName.text = product.
            /*Glide.with(productImageView.getContext())
                .load(product.md5_image)
                .into(productImageView)*/

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
                        like.isLiked = true

                    */


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
}}