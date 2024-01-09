package com.example.projectakhir.ui.AddCustomer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.projectakhir.Navigation.DestinasiNavigasi
import com.example.projectakhir.ui.AddEventCustomer

object AddCustomer {
    object DestinasiEntry : DestinasiNavigasi {
        override val route = "item_entry"
        override val titleRes = "Entry Customer"
    }
    @Composable
    fun FormInputCustomer(
        addEventCustomer: AddEventCustomer,
        modifier: Modifier = Modifier,
        onValueChange: (AddEventCustomer) -> Unit = {},
        enabled: Boolean = true
    ) {}
}