package com.thesis.android_challenge_w4.activity.restaurant_list

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.thesis.android_challenge_w4.R
import com.thesis.android_challenge_w4.data.getRestaurantList
import kotlinx.android.synthetic.main.activity_restaurant_list.*

class RestaurantListActivity : AppCompatActivity(){
    private lateinit var restaurantAdapter: RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_restaurant_list)
        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        val linearLayoutManager = GridLayoutManager(this,2)
        restaurantAdapter = RestaurantAdapter()
        restaurantAdapter.submitList(getRestaurantList())
        rv_restaurant_list.apply {
            layoutManager = linearLayoutManager
            adapter = restaurantAdapter
        }
    }
}