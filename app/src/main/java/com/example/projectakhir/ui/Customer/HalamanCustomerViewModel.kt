package com.example.projectakhir.ui.Customer

import com.example.projectakhir.model.Customer
import kotlinx.coroutines.flow.Flow

sealed class CustomerUIState {
    data class Success(val customer: Flow<List<Customer>>) : CustomerUIState()
    object Error : CustomerUIState()
    object Loading : CustomerUIState()
}