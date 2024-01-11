package com.example.projectakhir.data

import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer {
    val customerRepository: CustomerRepository
}

class PinjolContainer : AppContainer {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override val customerRepository: CustomerRepository by lazy {
        CustomerRepositoryImpl(firestore)
    }
}