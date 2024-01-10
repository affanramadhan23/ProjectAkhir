package com.example.projectakhir.ui.DetailCustomer

import com.example.projectakhir.Navigation.DestinasiNavigasi

object DetailDestinationCustomer : DestinasiNavigasi {
    override val route = "item_details_customer"
    override val titleRes = "Detail Customer"
    const val customerId = "itemCustomerId"
    val routeWithArgs = "$route/{${customerId}"
}