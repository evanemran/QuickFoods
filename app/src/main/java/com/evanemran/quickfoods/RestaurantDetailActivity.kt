package com.evanemran.quickfoods

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.evanemran.quickfoods.adapters.FoodsViewPagerAdapter
import com.evanemran.quickfoods.fragments.FoodListFragment
import com.evanemran.quickfoods.models.Foods
import com.evanemran.quickfoods.models.Restaurant
import com.google.android.material.tabs.TabLayout

class RestaurantDetailActivity : AppCompatActivity() {
    private val tabLayout: TabLayout? = null
    private val viewPager: ViewPager? = null
    private var viewPagerAdapter: FoodsViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)

        getCategory()
//        getFoodList()

    }

    private fun getCategory() {
        val categories: MutableList<String> = mutableListOf()
        categories.add("Burger")
        categories.add("Pizza")
        categories.add("Set Menu")
        categories.add("Pasta")
        categories.add("Steak")
        categories.add("Dessert")
        categories.add("Drinks")

        viewPager?.let { setupViewPager(it, categories) }
//        tabLayout!!.setupWithViewPager(viewPager)
    }

    private fun getFoodList() {
        val foods: MutableList<Foods> = mutableListOf()
        foods.add(Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal))
        foods.add(Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal))
        foods.add(Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal))
        foods.add(Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal))
        foods.add(Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal))
        foods.add(Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal))
        foods.add(Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal))
        foods.add(Foods("Burger Combo", "A combo of Beef/Chicken Burger with Potato Wedges and Oreo Shake", 250, R.drawable.meal))


    }

    private fun setupViewPager(viewPager: ViewPager, list: List<String>) {
        viewPagerAdapter = FoodsViewPagerAdapter(supportFragmentManager)


        for (item in list){
            val fragment = FoodListFragment()
            viewPagerAdapter!!.addFragment(fragment, item)
        }

        viewPager.adapter = viewPagerAdapter
        tabLayout!!.setupWithViewPager(viewPager)
    }
}