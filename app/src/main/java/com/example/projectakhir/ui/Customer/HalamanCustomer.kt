package com.example.projectakhir.ui.Customer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.projectakhir.Data.CustomerRepository
import com.example.projectakhir.Navigation.DestinasiNavigasi


object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = "Customer"
}


@Composable
fun CustomerScreen(
    navigateToItemEntryCustomerRepository: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (String) -> Unit = {},
) {}