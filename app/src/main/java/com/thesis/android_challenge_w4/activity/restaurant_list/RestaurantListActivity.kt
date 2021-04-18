package com.thesis.android_challenge_w4.activity.restaurant_list

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.thesis.android_challenge_w4.R
import com.thesis.android_challenge_w4.data.getRestaurantList
import kotlinx.android.synthetic.main.activity_restaurant_list.*


class RestaurantListActivity : AppCompatActivity(){
    private lateinit var restaurantAdapter: RestaurantAdapter
    private lateinit var menu: Menu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_restaurant_list)
        val toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setupRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_restaurant,menu)
        this.menu = menu!!
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.item_list_switch -> {
                Log.d("Test","Clicked")
                val isSwitched: Boolean = restaurantAdapter.toggleItemViewType()
                if(isSwitched){
                    rv_restaurant_list.layoutManager = LinearLayoutManager(this)
                    menu[0].icon = ContextCompat.getDrawable(this,R.drawable.ic_grid)
                } else {
                    rv_restaurant_list.layoutManager = GridLayoutManager(this,2)
                    menu[0].icon = ContextCompat.getDrawable(this,R.drawable.ic_linear)

                }
            }
        }
        return true
    }

    private fun setupRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(this)
        restaurantAdapter = RestaurantAdapter()
        restaurantAdapter.submitList(getRestaurantList())
        rv_restaurant_list.apply {
            layoutManager = linearLayoutManager
            adapter = restaurantAdapter
        }
    }

    private fun switchIcon(){

    }
}