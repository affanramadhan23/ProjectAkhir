package com.example.projectakhir.ui

import com.example.projectakhir.model.Customer

data class HomeUIState(
    val listAnggota: List<Customer> = listOf(),
    val dataLength: Int = 0
)
