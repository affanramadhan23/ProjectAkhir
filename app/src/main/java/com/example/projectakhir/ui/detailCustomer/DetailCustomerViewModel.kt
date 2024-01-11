package com.example.projectakhir.ui.detailCustomer

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir.data.CustomerRepository
import com.example.projectakhir.ui.DetailUIStateCustomer
import com.example.projectakhir.ui.toDetailCustomer
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class DetailCustomerViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: CustomerRepository
) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 6_000L
    }
    val customerId: String = checkNotNull(savedStateHandle[DetailDestinationCustomer.customerId])

    val uiStateCustomer: StateFlow<DetailUIStateCustomer> =
        repository.getCustomerById(customerId)
            .filterNotNull()
            .map {
                DetailUIStateCustomer(addEventCustomer = it.toDetailCustomer())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DetailUIStateCustomer()
            )
    suspend fun deleteCustomer() {
        repository.delete(customerId)
    }

}
