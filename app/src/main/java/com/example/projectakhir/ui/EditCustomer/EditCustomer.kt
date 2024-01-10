package com.example.projectakhir.ui.EditCustomer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectakhir.Navigation.DestinasiNavigasi
import com.example.projectakhir.ui.AddCustomer.EntryBodyCustomer
import com.example.projectakhir.ui.PenyediaViewModel
import kotlinx.coroutines.launch

object EditDestinationCustomer : DestinasiNavigasi {
    override val route = "item edit customer"
    override val titleRes ="Edit Customer"
    const val customerId = "customerId"
    val routeWithArgs = "${EditDestinationCustomer.route}/{$customerId}"
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreenCustomer(
    navigateBackCustomer: () -> Unit,
    onNavigateUpCustomer: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditCustomerViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()

    Scaffold() { innerPadding ->
        EntryBodyCustomer(
            addUIStateCustomer = viewModel.customerUIState,
            onCustomerValueChange = viewModel::updateUIStateCustomer,
            onSaveClickCustomer = {
                coroutineScope.launch {
                    viewModel.updateCustomer()
                    navigateBackCustomer()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}