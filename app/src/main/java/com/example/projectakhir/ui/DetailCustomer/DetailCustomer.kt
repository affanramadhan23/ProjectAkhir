package com.example.projectakhir.ui.DetailCustomer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectakhir.Navigation.DestinasiNavigasi
import com.example.projectakhir.model.Customer
import com.example.projectakhir.ui.DetailUIStateCustomer
import com.example.projectakhir.ui.PenyediaViewModel
import com.example.projectakhir.ui.toCustomer
import kotlinx.coroutines.launch

object DetailDestinationCustomer : DestinasiNavigasi {
    override val route = "item_details_customer"
    override val titleRes = "Detail Customer"
    const val customerId = "itemCustomerId"
    val routeWithArgs = "$route/{${customerId}"
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenCustomer(
    navigateToEditItemCustomer: (String) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailCustomerViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val uiStateCustomer = viewModel.uiStateCustomer.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold() { innerPadding ->
        ItemDetailsBodyCustomer(
            detailUIStateCustomer = uiStateCustomer.value,
            onDeleteCustomer = {
                coroutineScope.launch {
                    viewModel.deleteCustomer()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
        )
    }
}

@Composable
private fun ItemDetailsBodyCustomer(
    detailUIStateCustomer: DetailUIStateCustomer,
    onDeleteCustomer: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        var deleteConfirmationRequiredCustomer   by rememberSaveable { mutableStateOf(false) }
        ItemDetailsCustomer(
            customer = detailUIStateCustomer.addEventCustomer.toCustomer(),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedButton(
            onClick = { deleteConfirmationRequiredCustomer = true },
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Delete")
        }

        if (deleteConfirmationRequiredCustomer) {
            DeleteConfirmationDialog(
                onDeleteConfirmCustomer = {
                    deleteConfirmationRequiredCustomer = false
                    onDeleteCustomer()
                },
                onDeleteCancelCustomer = { deleteConfirmationRequiredCustomer = false },
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}
@Composable
fun ItemDetailsCustomer(
    customer: Customer,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ItemDetailsRowCustomer(
                labelResIDCustomer = "Nama",
                itemDetailCustomer = customer.nama,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )

            ItemDetailsRowCustomer(
                labelResIDCustomer = "Alamat",
                itemDetailCustomer = customer.alamat,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )

            ItemDetailsRowCustomer(
                labelResIDCustomer = "Jenis Kelamin",
                itemDetailCustomer = customer.jk,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )

            ItemDetailsRowCustomer(
                labelResIDCustomer = "Nomor Telepon",
                itemDetailCustomer = customer.nohp,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )
            ItemDetailsRowCustomer(
                labelResIDCustomer = "Pinjaman Dana",
                itemDetailCustomer = customer.pinjamandana,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )
            ItemDetailsRowCustomer(
                labelResIDCustomer = "Barang Jaminan",
                itemDetailCustomer = customer.barangjaminan,
                modifier = Modifier.padding(
                    horizontal = 12.dp
                )
            )
        }
    }
}

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