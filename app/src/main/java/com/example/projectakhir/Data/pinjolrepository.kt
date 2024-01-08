package com.example.projectakhir.Data

import com.example.projectakhir.model.Customer
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow


interface CustomerRepository {
    fun getAll(): Flow<List<Customer>>
    suspend fun save(customer: Customer): String
    suspend fun update(customer: Customer)
    suspend fun delete(customerId: String)
    fun getCustomerById(customerId: String): Flow<Customer>
}

class CustomerRepositoryImpl(private val firestore: FirebaseFirestore) : CustomerRepository {
    override fun getAll(): Flow<List<Customer>> {
        TODO("Not yet implemented")
    }

    override suspend fun save(customer: Customer): String {
        TODO("Not yet implemented")
    }

    override suspend fun update(customer: Customer) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(customerId: String) {
        TODO("Not yet implemented")
    }

    override fun getCustomerById(anggotaId: String): Flow<Customer> {
        TODO("Not yet implemented")
    }
}