package com.example.projectakhir.ui.EditCustomer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.projectakhir.Navigation.DestinasiNavigasi

object EditDestinationCustomer : DestinasiNavigasi {
    override val route = "item edit customer"
    override val titleRes ="Edit Customer"
    const val customerId = "customerId"
    val routeWithArgs = "${EditDestinationCustomer.route}/{$customerId}"
}
@Composable
fun EditScreenCustomer(
    navigateBackCustomer: () -> Unit,
    onNavigateUpCustomer: () -> Unit,
    modifier: Modifier = Modifier,
) {}