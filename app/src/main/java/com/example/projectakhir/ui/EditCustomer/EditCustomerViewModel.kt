package com.example.projectakhir.ui.EditCustomer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.projectakhir.Data.CustomerRepository
import com.example.projectakhir.ui.AddUIStateCustomer

class EditCustomerViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: CustomerRepository
) : ViewModel() {
    var customerUIState by mutableStateOf(AddUIStateCustomer())
        private set
    private val customerId: String = checkNotNull(savedStateHandle[EditDestinationCustomer.customerId])
}