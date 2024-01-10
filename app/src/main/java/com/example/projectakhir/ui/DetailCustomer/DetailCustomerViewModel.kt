package com.example.projectakhir.ui.DetailCustomer

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.projectakhir.Data.CustomerRepository

class DetailCustomerViewModel(
    savedStateHandle: SavedStateHandle,
    private val repository: CustomerRepository
) : ViewModel() {}