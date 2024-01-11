package com.example.projectakhir.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectakhir.Pinjol.PinjolApplication
import com.example.projectakhir.ui.AddCustomer.AddCustomerViewModel
import com.example.projectakhir.ui.DetailCustomer.DetailCustomerViewModel
import com.example.projectakhir.ui.EditCustomer.EditCustomerViewModel
import com.example.projectakhir.ui.HomeCustomer.HalamanCustomerViewModel

fun CreationExtras.aplikasiPinjol(): PinjolApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PinjolApplication)

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HalamanCustomerViewModel(aplikasiPinjol().container.customerRepository)
        }
        initializer {
            AddCustomerViewModel(aplikasiPinjol().container.customerRepository)
        }
        initializer {
            DetailCustomerViewModel(
                createSavedStateHandle(),
                aplikasiPinjol().container.customerRepository
            )
        }
        initializer {
            EditCustomerViewModel(
                createSavedStateHandle(),
                aplikasiPinjol().container.customerRepository
            )
        }
    }
}