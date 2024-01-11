package com.example.projectakhir.ui.homeCustomer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectakhir.navigation.DestinasiNavigasi
import com.example.projectakhir.model.Customer
import com.example.projectakhir.ui.CustomerTopAppBar
import com.example.projectakhir.ui.PenyediaViewModel


object DestinasiHomeCustomer : DestinasiNavigasi {
    override val route = "home Customer"
    override val titleRes = "Customer"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomerScreen(
    navigateToItemEntryCustomer: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClickCustomer: (String) -> Unit = {},
    viewModel: HalamanCustomerViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomerTopAppBar(
                title = "Customer",
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToItemEntryCustomer() },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(18.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    ) { innerPadding ->
        val uiStateCustomer by viewModel.homeUIStateCustomer.collectAsState()
        BodyHomeCustomer(
            itemCustomer = uiStateCustomer.listCustomer,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            onCustomerClick = onDetailClickCustomer
        )
    }
}
@Composable
fun BodyHomeCustomer(
    itemCustomer: List<Customer>,
    modifier: Modifier = Modifier,
    onCustomerClick: (String) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemCustomer.isEmpty()) {
            Text(
                text = "Tidak ada data Customer",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListCustomer(
                itemCustomer = itemCustomer,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                onItemClick = { onCustomerClick(it.id) }
            )
        }
    }
}
@Composable
fun ListCustomer(
    itemCustomer: List<Customer>,
    modifier: Modifier = Modifier,
    onItemClick: (Customer) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        this.items(itemCustomer, key = { it.id }) {customer ->
            DataCustomer(
                customer = customer,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(customer) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun DataCustomer(
    customer: Customer,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = customer.nama,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                )
                Text(
                    text = customer.nohp,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = customer.jk,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                )
                Text(
                    text = customer.alamat,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = customer.pinjamandana,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null,
                )
                Text(
                    text = customer.barangjaminan,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}