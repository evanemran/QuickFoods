package com.evanemran.quickfoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.evanemran.quickfoods.adapters.CartListAdapter
import com.evanemran.quickfoods.adapters.DealsAdapter
import com.evanemran.quickfoods.listeners.ClickListener
import com.evanemran.quickfoods.models.Deals
import com.evanemran.quickfoods.models.DrawerMenu
import com.evanemran.quickfoods.models.Foods
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.home_grids.*

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        setupCartData()

        button_reviewAddress.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
        }
    }

    private fun setupCartData() {
        val foodList: MutableList<Foods> = mutableListOf()
        foodList.add(Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.food_burger))
        foodList.add(Foods("Naga Wings", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 185, R.drawable.food_wings))
        foodList.add(Foods("Red Velvet", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 150, R.drawable.food_velvet))
        foodList.add(Foods("Oreo Shake", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 165, R.drawable.food_shake))

        recycler_cartItem.setHasFixedSize(true)
        recycler_cartItem.isNestedScrollingEnabled = false
        recycler_cartItem.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val cartListAdapter = CartListAdapter(this, foodList, cartClickListener)
        recycler_cartItem.adapter = cartListAdapter
    }

    private val cartClickListener: ClickListener<Foods> = object :
        ClickListener<Foods> {
        override fun onClicked(data: Foods) {
//            startActivity(Intent(this@CartActivity, RestaurantsActivity::class.java))
        }

    }
}