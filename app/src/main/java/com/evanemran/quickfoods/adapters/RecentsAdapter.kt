package com.evanemran.quickfoods.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.evanemran.quickfoods.R
import com.evanemran.quickfoods.listeners.ClickListener
import com.evanemran.quickfoods.models.Cuisine
import com.evanemran.quickfoods.models.Deals
import com.evanemran.quickfoods.models.Restaurant
import com.evanemran.quickfoods.models.Service
import com.squareup.picasso.Picasso


class RecentsAdapter (val context: Context, val list: List<Restaurant>, val listener: ClickListener<Restaurant>)
    : RecyclerView.Adapter<RecentsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentsViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.list_recents, parent, false)
        return RecentsViewHolder(layout)
    }

    override fun onBindViewHolder(holder: RecentsViewHolder, position: Int) {
        val item = list[holder.adapterPosition]

        holder.textView_restaurantName.setText(item.restaurantName)
        holder.imageView_restaurants.setImageResource(item.restaurantBanner)


        holder.restaurant_container.setOnClickListener {
            listener.onClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class RecentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textView_restaurantName: TextView
    var imageView_restaurants: ImageView
    var restaurant_container: LinearLayout

    init {
        textView_restaurantName = itemView.findViewById(R.id.textView_restaurantName)
        restaurant_container = itemView.findViewById(R.id.restaurant_container)
        imageView_restaurants = itemView.findViewById(R.id.imageView_restaurants)
    }
}