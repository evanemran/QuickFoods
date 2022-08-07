package com.evanemran.quickfoods.models

import com.google.android.gms.maps.model.LatLng
import java.io.Serializable

class Address(var id: Int, var name: String, var type: String, var latLng: LatLng, var isPrimary: Boolean) : Serializable {
    var addressId: Int = id
    var addressName: String = name
    var addressType: String = type
    var addressLatLng: LatLng = latLng
    var isPrimaryAddress: Boolean = isPrimary
}