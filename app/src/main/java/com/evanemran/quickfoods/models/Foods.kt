package com.evanemran.quickfoods.models

import java.io.Serializable

class Foods(title: String, info: String, price: Int, image: Int) : Serializable{
    var foodName: String = title
    var foodInfo: String = info
    var foodPrice: Int = price
    var foodImage: Int = image
}