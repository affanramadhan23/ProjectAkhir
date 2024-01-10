package com.example.projectakhir.ui.EditCustomer

import com.example.projectakhir.Navigation.DestinasiNavigasi

object EditDestinationCustomer : DestinasiNavigasi {
    override val route = "item edit customer"
    override val titleRes ="Edit Customer"
    const val customerId = "customerId"
    val routeWithArgs = "${EditDestinationCustomer.route}/{$customerId}"
}