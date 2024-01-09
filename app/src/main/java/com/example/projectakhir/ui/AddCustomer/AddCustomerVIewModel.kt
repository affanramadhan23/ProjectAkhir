package com.example.projectakhir.ui.AddCustomer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.projectakhir.Data.CustomerRepository
import com.example.projectakhir.ui.AddUIStateCustomer

class AddCustomerViewModel(private val customerRepository: CustomerRepository) : ViewModel() {
    var addUIStateCustomer by mutableStateOf(AddUIStateCustomer())
        private set
}