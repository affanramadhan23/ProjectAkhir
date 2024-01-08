package com.example.projectakhir.Data

import com.example.projectakhir.model.Customer
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await


interface CustomerRepository {
    fun getAll(): Flow<List<Customer>>
    suspend fun save(customer: Customer): String
    suspend fun update(customer: Customer)
    suspend fun delete(customerId: String)
    fun getCustomerById(customerId: String): Flow<Customer>
}

class CustomerRepositoryImpl(private val firestore: FirebaseFirestore) : CustomerRepository {
    override fun getAll(): Flow<List<Customer>> = flow {
        val snapshot = firestore.collection("Customer")
            .orderBy("nama", Query.Direction.ASCENDING)
            .get()
            .await()
        val anggota = snapshot.toObjects(Customer::class.java)
        emit(anggota)
    }.flowOn(Dispatchers.IO)

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