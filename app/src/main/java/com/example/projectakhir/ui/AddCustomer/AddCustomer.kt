package com.example.projectakhir.ui.AddCustomer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectakhir.Navigation.DestinasiNavigasi
import com.example.projectakhir.ui.AddEventCustomer
import com.example.projectakhir.ui.AddUIStateCustomer
import com.example.projectakhir.ui.CustomerTopAppBar
import com.example.projectakhir.ui.PenyediaViewModel
import kotlinx.coroutines.launch

object AddCustomer {
    object DestinasiEntry : DestinasiNavigasi {
        override val route = "item_entry"
        override val titleRes = "Entry Customer"
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AddCustomer(
        navigateBack: () -> Unit,
        modifier: Modifier = Modifier,
        addCustomerViewModel: AddCustomerViewModel = viewModel(factory = PenyediaViewModel.Factory)
    ) {
        val coroutineScope = rememberCoroutineScope()
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

        Scaffold(
            modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                CustomerTopAppBar(
                    title = DestinasiEntry.titleRes,
                    canNavigateBack = true,
                    scrollBehavior = scrollBehavior,
                    navigateUp = navigateBack
                )
            }
        ) { innerPadding ->
            EntryBodyCustomer(
                addUIStateCustomer = addCustomerViewModel.addUIStateCustomer,
                onCustomerValueChange = addCustomerViewModel::updateAddUIStateCustomer,
                onSaveClickCustomer = {
                    coroutineScope.launch {
                        addCustomerViewModel.addCustomer()
                        navigateBack()
                    }
                },
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
            )
        }
    }
    @Composable
    fun EntryBodyCustomer(
        addUIStateCustomer: AddUIStateCustomer,
        onCustomerValueChange: (AddEventCustomer) -> Unit,
        onSaveClickCustomer: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = modifier.padding(12.dp)
        ) {
            FormInputCustomer(
                addEventCustomer = addUIStateCustomer.addEventCustomer,
                onValueChangeCustomer = onCustomerValueChange,
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = onSaveClickCustomer,
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Submit")
            }
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FormInputCustomer(
        addEventCustomer: AddEventCustomer,
        modifier: Modifier = Modifier,
        onValueChangeCustomer: (AddEventCustomer) -> Unit = {},
        enabled: Boolean = true
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = addEventCustomer.nama,
                onValueChange = { onValueChangeCustomer(addEventCustomer.copy(nama = it)) },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )

            OutlinedTextField(
                value = addEventCustomer.alamat,
                onValueChange = { onValueChangeCustomer(addEventCustomer.copy(alamat = it)) },
                label = { Text("Alamat") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )

            OutlinedTextField(
                value = addEventCustomer.jk,
                onValueChange = { onValueChangeCustomer(addEventCustomer.copy(jk = it)) },
                label = { Text("Jenis Kelamin") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )

            OutlinedTextField(
                value = addEventCustomer.nohp,
                onValueChange = { onValueChangeCustomer(addEventCustomer.copy(nohp = it)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(text = "Nomor Telepon") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
            OutlinedTextField(
                value = addEventCustomer.pinjamandana,
                onValueChange = { onValueChangeCustomer(addEventCustomer.copy(pinjamandana = it)) },
                label = { Text("Pinjaman Dana") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )

            OutlinedTextField(
                value = addEventCustomer.barangjaminan,
                onValueChange = { onValueChangeCustomer(addEventCustomer.copy(barangjaminan = it)) },
                label = { Text("Barang Jaminan") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
        }
    }
}