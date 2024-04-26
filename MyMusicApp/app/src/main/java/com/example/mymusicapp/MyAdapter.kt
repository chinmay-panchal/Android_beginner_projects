package com.example.mymusicapp

import android.app.Activity
import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val dataList: List<Data>) :

    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView
        val title: TextView
        val play: ImageButton
        val pause: ImageButton

        init {
            image = itemView.findViewById(R.id.musicPicture)
            title = itemView.findViewById(R.id.musicTitle)
            play = itemView.findViewById(R.id.btnPlay)
            pause = itemView.findViewById(R.id.btnPause)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentData = dataList[position]
        val mediaPlayer = MediaPlayer.create(context, currentData.preview.toUri())

        // image
        Picasso.get().load(currentData.album.cover).into(holder.image);

        //title
        holder.title.text = currentData.title

        // play
        holder.play.setOnClickListener {
            mediaPlayer.start()
        }

        // pause
        holder.pause.setOnClickListener {
            mediaPlayer.start()
        }
    }

}