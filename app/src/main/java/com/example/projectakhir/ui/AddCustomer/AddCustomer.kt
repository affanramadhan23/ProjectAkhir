package com.example.projectakhir.ui.AddCustomer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.projectakhir.Navigation.DestinasiNavigasi
import com.example.projectakhir.ui.AddEventCustomer
import com.example.projectakhir.ui.AddUIStateCustomer

object AddCustomer {
    object DestinasiEntry : DestinasiNavigasi {
        override val route = "item_entry"
        override val titleRes = "Entry Customer"
    }
    @Composable
    fun EntryBodyCustomer(
        addUIStateCustomer: AddUIStateCustomer,
        onCustomerValueChange: (AddEventCustomer) -> Unit,
        onSaveClickCustomer: () -> Unit,
        modifier: Modifier = Modifier
    ) {}
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FormInputCustomer(
        addEventCustomer: AddEventCustomer,
        modifier: Modifier = Modifier,
        onValueChange: (AddEventCustomer) -> Unit = {},
        enabled: Boolean = true
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = addEventCustomer.nama,
                onValueChange = { onValueChange(addEventCustomer.copy(nama = it)) },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )

            OutlinedTextField(
                value = addEventCustomer.alamat,
                onValueChange = { onValueChange(addEventCustomer.copy(alamat = it)) },
                label = { Text("Alamat") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )

            OutlinedTextField(
                value = addEventCustomer.jk,
                onValueChange = { onValueChange(addEventCustomer.copy(jk = it)) },
                label = { Text("Jenis Kelamin") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )

            OutlinedTextField(
                value = addEventCustomer.nohp,
                onValueChange = { onValueChange(addEventCustomer.copy(nohp = it)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(text = "Nomor Telepon") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
            OutlinedTextField(
                value = addEventCustomer.pinjamandana,
                onValueChange = { onValueChange(addEventCustomer.copy(pinjamandana = it)) },
                label = { Text("Pinjaman Dana") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )

            OutlinedTextField(
                value = addEventCustomer.barangjaminan,
                onValueChange = { onValueChange(addEventCustomer.copy(barangjaminan = it)) },
                label = { Text("Barang Jaminan") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
        }
    }
}