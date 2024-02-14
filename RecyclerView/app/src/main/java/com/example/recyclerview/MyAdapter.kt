package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsArrayList: ArrayList<News>, var context : Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private lateinit var myListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClicking(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    // when layout manager while binding the view
    // fails to find a suitable view for each item
    // to create new view instance

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        return MyViewHolder(itemView, myListener)
    }

    // Assign the data (image,title) to the items according to the position
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.hTitle.text = currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)
    }


    // Keeps the count of elements in the ArrayList of type Data-Class
    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val hTitle = itemView.findViewById<TextView>(R.id.headingTitle)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)

        init {
            itemView.setOnClickListener {
                listener.onItemClicking(adapterPosition)
            }
        }
    }

}