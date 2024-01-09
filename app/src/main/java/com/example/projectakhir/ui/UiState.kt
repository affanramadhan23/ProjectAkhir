package com.example.projectakhir.ui

import com.example.projectakhir.model.Customer

data class HomeUIState(
    val listAnggota: List<Customer> = listOf(),
    val dataLength: Int = 0
)
data class AddEvent(
    val id: String = "",
    val nama: String = "",
    val alamat: String = "",
    val jk: String = "",
    val nohp: String = "",
    val pinjamandana:  String = "",
    val barangjaminan: String = ""
)
fun Customer.toDetailCustomer(): AddEvent =
    AddEvent(
        id = id,
        nama = nama,
        alamat = alamat,
        jk = jk,
        nohp = nohp,
        pinjamandana = pinjamandana,
        barangjaminan = barangjaminan
    )