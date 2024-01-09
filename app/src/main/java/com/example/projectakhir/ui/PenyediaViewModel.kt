package com.example.projectakhir.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.projectakhir.Pinjol.PinjolApplication

fun CreationExtras.aplikasiPerpus(): PinjolApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PinjolApplication)