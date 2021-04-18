package com.thesis.android_challenge_w4.activity.restaurant_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thesis.android_challenge_w4.R
import com.thesis.android_challenge_w4.model.Restaurant

class RestaurantAdapter :
    ListAdapter<Restaurant, RestaurantAdapter.ViewHolder>(RestaurantDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = getItem(position)
        holder.bind(item)
    }

     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvRestaurantName = itemView.findViewById<TextView>(R.id.tv_restaurant_name)
        val tvRestaurantAddress = itemView.findViewById<TextView>(R.id.tv_restaurant_address)
        val imgRestaurant = itemView.findViewById<ImageView>(R.id.img_restaurant)

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.item_restaurant, parent, false)
                return ViewHolder(view)
            }
        }

        fun bind(restaurant: Restaurant) {
            tvRestaurantName.text = restaurant.name
            tvRestaurantAddress.text = restaurant.address
            Glide.with(itemView.context)
                .load(restaurant.picturePath)
                .into(imgRestaurant)

        }
    }


    class RestaurantDiffUtilCallback : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.address == newItem.address
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }

}