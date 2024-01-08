package com.example.projectakhir.Data

import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer {
    val customerRepository: CustomerRepository
}

class pinjolContainer : AppContainer {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override val customerRepository: CustomerRepository by lazy {
        CustomerRepositoryImpl(firestore)
    }
}