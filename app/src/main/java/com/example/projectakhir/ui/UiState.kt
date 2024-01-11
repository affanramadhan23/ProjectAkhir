package com.example.projectakhir.ui

import com.example.projectakhir.model.Customer

data class HomeUIStateCustomer(
    val listCustomer: List<Customer> = listOf(),
    val dataLength: Int = 0
)
data class AddEventCustomer(
    val id: String = "",
    val nama: String = "",
    val alamat: String = "",
    val jk: String = "",
    val nohp: String = "",
    val pinjamandana:  String = "",
    val barangjaminan: String = ""
)
fun Customer.toDetailCustomer(): AddEventCustomer =
    AddEventCustomer(
        id = id,
        nama = nama,
        alamat = alamat,
        jk = jk,
        nohp = nohp,
        pinjamandana = pinjamandana,
        barangjaminan = barangjaminan
    )
fun AddEventCustomer.toCustomer() = Customer(
    id = id,
    nama = nama,
    alamat = alamat,
    jk = jk,
    nohp = nohp,
    pinjamandana = pinjamandana,
    barangjaminan = barangjaminan
)

data class AddUIStateCustomer(
    val addEventCustomer: AddEventCustomer = AddEventCustomer(),
)
fun Customer.toUIStateCustomer(): AddUIStateCustomer = AddUIStateCustomer(
    addEventCustomer = this.toDetailCustomer()
)
data class DetailUIStateCustomer(
    val addEventCustomer: AddEventCustomer = AddEventCustomer()
)