package com.evanemran.quickfoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.evanemran.quickfoods.adapters.DealsAdapter
import com.evanemran.quickfoods.adapters.RestaurantAdapter
import com.evanemran.quickfoods.listeners.ClickListener
import com.evanemran.quickfoods.models.Cuisine
import com.evanemran.quickfoods.models.Deals
import com.evanemran.quickfoods.models.Restaurant
import kotlinx.android.synthetic.main.activity_restaurants.*
import kotlinx.android.synthetic.main.home_grids.*

class RestaurantsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)


        setupRestaurants()
    }

    private fun setupRestaurants() {
        val restaurants: MutableList<Restaurant> = mutableListOf()
        restaurants.add(Restaurant("ABC Restaurant"))
        restaurants.add(Restaurant("Coding Cafe"))
        restaurants.add(Restaurant("Evan's Dine"))
        restaurants.add(Restaurant("Adda Buzz"))
        restaurants.add(Restaurant("Iramon Cafe"))
        restaurants.add(Restaurant("Food Chemistry"))
        restaurants.add(Restaurant("Lol Cafe"))

        recycler_restaurants.setHasFixedSize(true)
        recycler_restaurants.isNestedScrollingEnabled = false
        recycler_restaurants.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val restaurantAdapter = RestaurantAdapter(this, restaurants, restaurantClickListener)
        recycler_restaurants.adapter = restaurantAdapter
    }

    private val restaurantClickListener: ClickListener<Restaurant> = object : ClickListener<Restaurant> {
        override fun onClicked(data: Restaurant) {
            startActivity(Intent(this@RestaurantsActivity, RestaurantDetailActivity::class.java))
        }

    }
}