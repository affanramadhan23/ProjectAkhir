package com.example.projectakhir.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.projectakhir.ui.addCustomer.AddCustomer
import com.example.projectakhir.ui.addCustomer.DestinasiEntryCustomer
import com.example.projectakhir.ui.detailCustomer.DetailDestinationCustomer
import com.example.projectakhir.ui.detailCustomer.DetailScreenCustomer
import com.example.projectakhir.ui.editCustomer.EditDestinationCustomer
import com.example.projectakhir.ui.editCustomer.EditScreenCustomer
import com.example.projectakhir.ui.halaman.DestinasiHome
import com.example.projectakhir.ui.halaman.DestinasiUtama
import com.example.projectakhir.ui.halaman.HalamanHome
import com.example.projectakhir.ui.halaman.HalamanUtama
import com.example.projectakhir.ui.homeCustomer.CustomerScreen
import com.example.projectakhir.ui.homeCustomer.DestinasiHomeCustomer

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            HalamanHome(    navController)
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
                onDetailClickCustomer = { itemIdCustomer ->
                    navController.navigate("${DetailDestinationCustomer.route}/$itemIdCustomer")
                    println("itemIdCustomer: $itemIdCustomer")
                }
            )
        }

        composable(
            route = DetailDestinationCustomer.routeWithArgs,
            arguments = listOf(navArgument(DetailDestinationCustomer.customerId) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val customerId =
                backStackEntry.arguments?.getString(DetailDestinationCustomer.customerId)
            customerId?.let {
                DetailScreenCustomer(
                    navigateToEditItemCustomer = {
                        navController.navigate("${EditDestinationCustomer.route}/$customerId")
                        println("anggotaId: $customerId")
                    },
                    navigateBack = {navController.popBackStack()})
            }
        }
        composable(DestinasiEntryCustomer.route) {
            AddCustomer(
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(
            route = EditDestinationCustomer.routeWithArgs,
            arguments = listOf(navArgument(EditDestinationCustomer.customerId) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val customerId = backStackEntry.arguments?.getString(EditDestinationCustomer.customerId)
            customerId?.let {
                EditScreenCustomer(
                    navigateBackCustomer = { navController.popBackStack() },
                    onNavigateUpCustomer = { navController.navigateUp() })
            }
        }
    }
}