package com.example.projectakhir.ui.homeCustomer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.data.CustomerRepository
import com.example.projectakhir.model.Customer
import com.example.projectakhir.ui.HomeUIStateCustomer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

sealed class CustomerUIState {
    data class Success(val customer: Flow<List<Customer>>) : CustomerUIState()
    object Error : CustomerUIState()
    object Loading : CustomerUIState()
}
class HalamanCustomerViewModel(private val customerRepository: CustomerRepository) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 6_000L
    }

    val homeUIStateCustomer: StateFlow<HomeUIStateCustomer> = customerRepository.getAll()
        .filterNotNull()
        .map {
            HomeUIStateCustomer (listCustomer = it.toList(), it.size)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIStateCustomer()
        )
}