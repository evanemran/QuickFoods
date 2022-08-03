package com.evanemran.quickfoods
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.evanemran.quickfoods.adapters.CuisineAdapter
import com.evanemran.quickfoods.adapters.DealsAdapter
import com.evanemran.quickfoods.adapters.ServiceAdapter
import com.evanemran.quickfoods.listeners.ClickListener
import com.evanemran.quickfoods.models.Cuisine
import com.evanemran.quickfoods.models.Deals
import com.evanemran.quickfoods.models.Service
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_grids.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    var drawer: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.open_nav_drawer, R.string.close_nav_drawer
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        setupServices()
        setupDeals()
        setupCuisine()

    }

    private fun setupCuisine() {
        val cuisines: MutableList<Cuisine> = mutableListOf()
        cuisines.add(Cuisine(0, R.drawable.cuisine, "Fastfood"))
        cuisines.add(Cuisine(1, R.drawable.cuisine, "Dessert"))
        cuisines.add(Cuisine(2, R.drawable.cuisine, "Asian"))
        cuisines.add(Cuisine(3, R.drawable.cuisine, "Bangladeshi"))
        cuisines.add(Cuisine(4, R.drawable.cuisine, "Italian"))
        cuisines.add(Cuisine(5, R.drawable.cuisine, "Chinese"))
        cuisines.add(Cuisine(6, R.drawable.cuisine, "Indian"))
        cuisines.add(Cuisine(6, R.drawable.cuisine, "Japanese"))
        cuisines.add(Cuisine(6, R.drawable.cuisine, "Beverage"))
        cuisines.add(Cuisine(6, R.drawable.cuisine, "American"))

        recycler_cuisine.setHasFixedSize(true)
        recycler_cuisine.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL)
        val cuisineAdapter = CuisineAdapter(this, cuisines, cuisineClickListener)
        recycler_cuisine.adapter = cuisineAdapter
    }

    private fun setupDeals() {
        val deals: MutableList<Deals> = mutableListOf()
        deals.add(Deals(0, R.drawable.deals))
        deals.add(Deals(1, R.drawable.deals))
        deals.add(Deals(2, R.drawable.deals))
        deals.add(Deals(3, R.drawable.deals))
        deals.add(Deals(4, R.drawable.deals))
        deals.add(Deals(5, R.drawable.deals))
        deals.add(Deals(6, R.drawable.deals))

        recycler_deals.setHasFixedSize(true)
        recycler_deals.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val dealsAdapter = DealsAdapter(this, deals, dealsClickListener)
        recycler_deals.adapter = dealsAdapter
    }

    private fun setupServices() {
        val services: MutableList<Service> = mutableListOf()
        services.add(Service.DELIVERY)
        services.add(Service.MART)
        services.add(Service.DINE_IN)
        services.add(Service.SHOPS)
        services.add(Service.PICKUP)

        recycler_service.setHasFixedSize(true)
        recycler_service.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        val serviceAdapter = ServiceAdapter(this, services, servicesClickListener)
        recycler_service.adapter = serviceAdapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }

    private val servicesClickListener: ClickListener<Service> = object : ClickListener<Service>{
        override fun onClicked(data: Service) {
            Toast.makeText(this@MainActivity, data.title, Toast.LENGTH_SHORT).show()
        }

    }

    private val dealsClickListener: ClickListener<Deals> = object : ClickListener<Deals>{
        override fun onClicked(data: Deals) {
            Toast.makeText(this@MainActivity, "Clicked!", Toast.LENGTH_SHORT).show()
        }

    }

    private val cuisineClickListener: ClickListener<Cuisine> = object : ClickListener<Cuisine>{
        override fun onClicked(data: Cuisine) {
            startActivity(Intent(this@MainActivity, RestaurantsActivity::class.java))
        }

    }
}