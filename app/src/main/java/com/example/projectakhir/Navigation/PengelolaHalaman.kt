package com.example.projectakhir.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectakhir.ui.AddCustomer.AddCustomer
import com.example.projectakhir.ui.AddCustomer.DestinasiEntryCustomer
import com.example.projectakhir.ui.Halaman.DestinasiHome
import com.example.projectakhir.ui.Halaman.DestinasiUtama
import com.example.projectakhir.ui.Halaman.HalamanHome
import com.example.projectakhir.ui.Halaman.HalamanUtama
import com.example.projectakhir.ui.HomeCustomer.CustomerScreen
import com.example.projectakhir.ui.HomeCustomer.DestinasiHomeCustomer

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            HalamanHome (
                onNextButtonClicked = {
                    navController.navigate(DestinasiUtama.route)
                },
            )
        }

        composable(DestinasiUtama.route) {
            HalamanUtama(
                onCustomerClick = { navController.navigate(DestinasiHomeCustomer.route) }
            )
        }

        composable(DestinasiHomeCustomer.route) {
            CustomerScreen(
                navigateToItemEntryCustomer = {
                    navController.navigate(DestinasiEntryCustomer.route)
                },
                onDetailClickCustomer = { }
            )
        }

        composable(DestinasiEntryCustomer.route) {
            AddCustomer(
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}