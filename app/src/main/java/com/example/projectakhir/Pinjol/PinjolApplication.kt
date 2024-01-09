package com.example.projectakhir.Pinjol

import android.app.Application
import com.example.projectakhir.Data.AppContainer
import com.example.projectakhir.Data.pinjolContainer

class PinjolApplication : Application() {
        lateinit var container: AppContainer

        override fun onCreate() {
            super.onCreate()

            container = pinjolContainer()
        }
}