package com.example.projectakhir.ui.EditCustomer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.Data.CustomerRepository
import com.example.projectakhir.ui.AddEventCustomer
import com.example.projectakhir.ui.AddUIStateCustomer
import com.example.projectakhir.ui.toUIStateCustomer
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditCustomerViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: CustomerRepository
) : ViewModel() {
    var customerUIState by mutableStateOf(AddUIStateCustomer())
        private set
    private val customerId: String = checkNotNull(savedStateHandle[EditDestinationCustomer.customerId])

    init {
        viewModelScope.launch {
            customerUIState =
                repository.getCustomerById(customerId)
                    .filterNotNull()
                    .first()
                    .toUIStateCustomer()
        }
    }
    fun updateUIStateCustomer(addEventCustomer: AddEventCustomer) {
        customerUIState = customerUIState.copy(addEventCustomer = addEventCustomer)
    }
}