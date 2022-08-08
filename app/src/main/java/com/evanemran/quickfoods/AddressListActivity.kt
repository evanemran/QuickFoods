package com.evanemran.quickfoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.evanemran.quickfoods.adapters.AddressAdapter
import com.evanemran.quickfoods.adapters.DealsAdapter
import com.evanemran.quickfoods.listeners.ClickListener
import com.evanemran.quickfoods.models.Address
import com.evanemran.quickfoods.models.DrawerMenu
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.activity_address_list.*
import kotlinx.android.synthetic.main.home_grids.*

class AddressListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address_list)

        showAddresses()
    }

    private fun showAddresses() {
        val addresses: MutableList<Address> = mutableListOf()
        addresses.add(Address(0, "12th Floor - 50, Bay Tower, Mohakhali", "Work", LatLng(27.435539, 95.392441), false))
        addresses.add(Address(0, "17th Floor - Stark Tower, LA", "Home", LatLng(37.056519, -94.537453), true))
        addresses.add(Address(0, "House 112/A, GK Road, Noida", "Love", LatLng(27.435539, 95.392441), false))

        recycler_addresses.setHasFixedSize(true)
        recycler_addresses.isNestedScrollingEnabled = false
        recycler_addresses.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val addressAdapter = AddressAdapter(this,
            Address(0, "17th Floor - Stark Tower, LA", "Home", LatLng(37.056519, -94.537453), true) ,
            addresses,
            addressClickListener)
        recycler_addresses.adapter = addressAdapter
    }


    private val addressClickListener: ClickListener<Address> = object :
        ClickListener<Address> {
        override fun onClicked(data: Address) {
            Toast.makeText(this@AddressListActivity, "Clicked " + data.addressName, Toast.LENGTH_SHORT).show()
        }

    }
}