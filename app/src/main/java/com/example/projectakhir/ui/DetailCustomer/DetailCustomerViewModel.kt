package com.example.projectakhir.ui.DetailCustomer

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.projectakhir.Data.CustomerRepository

class DetailCustomerViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: CustomerRepository
) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 6_000L
    }
}