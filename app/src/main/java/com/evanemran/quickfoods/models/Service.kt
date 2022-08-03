package com.evanemran.quickfoods.models

import com.evanemran.quickfoods.R

enum class Service(title: String, subtitle: String, icon: Int) {

    DELIVERY("Food Delivery","Best deals on your favorites", R.drawable.food_delivery),
    MART("Quick Mart","Grocery delivered in 30 mins!", R.drawable.mart),
    DINE_IN("Dine In", "Exclusive offers", R.drawable.dine),
    SHOPS("Shops", "Groceries and more..", R.drawable.shops),
    PICKUP("Pick-up", "Takeaway in 15 mins", R.drawable.pickup);

    var title: String = title
    var subtitle: String = subtitle
    var icon: Int = icon

}