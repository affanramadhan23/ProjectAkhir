package com.example.projectakhir.Data

import android.content.ContentValues
import android.util.Log
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
        val customer = snapshot.toObjects(Customer::class.java)
        emit(customer)
    }.flowOn(Dispatchers.IO)

    override suspend fun save(customer: Customer): String {
        return try {
            val documentReference = firestore.collection("Customer")
                .add(customer)
                .await()
            firestore.collection("Customer").document(documentReference.id)
                .set(customer.copy(id = documentReference.id))
            "Berhasil + ${documentReference.id}"
        } catch (e: Exception) {
            Log.w(ContentValues.TAG, "Error adding document", e)
            "Gagal $e"
        }
    }

    override suspend fun update(customer: Customer) {
        firestore.collection("Customer").document(customer.id).set(customer).await()
    }

    override suspend fun delete(customerId: String) {
        firestore.collection("Customer").document(customerId).delete().await()
    }

    override fun getCustomerById(anggotaId: String): Flow<Customer> {
        return flow {
            val snapshot = firestore.collection("Anggota").document(anggotaId).get().await()
            val customer = snapshot.toObject(Customer::class.java)
            emit(customer!!)
        }.flowOn(Dispatchers.IO)
    }
}