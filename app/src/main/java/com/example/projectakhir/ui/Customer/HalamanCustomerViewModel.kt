package com.example.projectakhir.ui.Customer

import androidx.lifecycle.ViewModel
import com.example.projectakhir.Data.CustomerRepository
import com.example.projectakhir.model.Customer
import kotlinx.coroutines.flow.Flow

sealed class CustomerUIState {
    data class Success(val customer: Flow<List<Customer>>) : CustomerUIState()
    object Error : CustomerUIState()
    object Loading : CustomerUIState()
}
class HomeViewModel(private val CustomerRepository: CustomerRepository) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 6_000L
    }
}