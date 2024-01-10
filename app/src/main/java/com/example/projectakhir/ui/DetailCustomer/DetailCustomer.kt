package com.example.projectakhir.ui.DetailCustomer

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.projectakhir.Navigation.DestinasiNavigasi
import com.example.projectakhir.model.Customer

object DetailDestinationCustomer : DestinasiNavigasi {
    override val route = "item_details_customer"
    override val titleRes = "Detail Customer"
    const val customerId = "itemCustomerId"
    val routeWithArgs = "$route/{${customerId}"
}
@Composable
fun ItemDetails(
    customer: Customer,
    modifier: Modifier = Modifier
) {}

@Composable
private fun ItemDetailsRowCustomer(
    labelResIDCustomer: String,
    itemDetailCustomer: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(text = labelResIDCustomer, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = itemDetailCustomer, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun DeleteConfirmationDialog(
    onDeleteConfirmCustomer: () -> Unit,
    onDeleteCancelCustomer: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = { Text("Are you sure")},
        text = { Text("Delete")},
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDeleteCancelCustomer) {
                Text(text = "No")
            }
        },
        confirmButton = {
            TextButton(onClick = onDeleteConfirmCustomer) {
                Text(text = "Yes")
            }
        }
    )
}