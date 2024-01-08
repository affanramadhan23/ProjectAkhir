package com.example.projectakhir.Data

import com.example.projectakhir.model.Customer
import kotlinx.coroutines.flow.Flow


interface CustomerRepository {
    fun getAll(): Flow<List<Customer>>
    suspend fun save(customer: Customer): String
    suspend fun update(customer: Customer)
    suspend fun delete(customerId: String)
    fun getCustomerById(customerId: String): Flow<Customer>
}