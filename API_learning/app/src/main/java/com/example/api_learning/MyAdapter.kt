package com.example.api_learning

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.View.DragShadowBuilder
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.currentCoroutineContext

class MyAdapter(val context : Activity, val productArrayList : List<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
        // image view , how to show image in image view if the image is in form of url, 3rd Party Library
        // Picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image);
        if(currentItem.rating>=1 && currentItem.rating<2){
            holder.rating.setImageResource(R.drawable.onestar)
        }

        else if(currentItem.rating>=2 && currentItem.rating<3){
            holder.rating.setImageResource(R.drawable.twostar)
        }

        else if(currentItem.rating>=3 && currentItem.rating<4){
            holder.rating.setImageResource(R.drawable.threestar)
        }

        else if(currentItem.rating>=4 && currentItem.rating<5){
            holder.rating.setImageResource(R.drawable.fourstar)
        }

        else if(currentItem.rating== 5.toDouble()){
            holder.rating.setImageResource(R.drawable.fivestar)
        }
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var title : TextView
        var image : ShapeableImageView
        var rating : ImageView

        init {
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productImage)
            rating = itemView.findViewById(R.id.Rating)
        }
    }

}