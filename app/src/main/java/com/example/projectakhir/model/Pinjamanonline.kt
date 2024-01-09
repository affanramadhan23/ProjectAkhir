package com.example.projectakhir.model

data class Customer(
    val id: String,
    val nama: String,
    val alamat: String,
    val jk: String,
    val nohp: String,
    val pinjamandana: String,
    val barangjaminan: String
) {
    constructor(): this("","","","","","","")
}
