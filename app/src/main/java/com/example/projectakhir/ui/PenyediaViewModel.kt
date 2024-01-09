package com.example.projectakhir.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectakhir.Pinjol.PinjolApplication
import com.example.projectakhir.ui.HomeCustomer.HalamanCustomerViewModel

fun CreationExtras.aplikasiPinjol(): PinjolApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PinjolApplication)

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HalamanCustomerViewModel(aplikasiPinjol().container.customerRepository)
        }
    }
}