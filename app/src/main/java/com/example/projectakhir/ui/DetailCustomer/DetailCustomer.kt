package com.example.projectakhir.ui.DetailCustomer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.projectakhir.Navigation.DestinasiNavigasi

object DetailDestinationCustomer : DestinasiNavigasi {
    override val route = "item_details_customer"
    override val titleRes = "Detail Customer"
    const val customerId = "itemCustomerId"
    val routeWithArgs = "$route/{${customerId}"
}

@Composable
private fun DeleteConfirmationDialog(
    onDeleteConfirmCustomer: () -> Unit,
    onDeleteCancelCustomer: () -> Unit,
    modifier: Modifier = Modifier
) {}