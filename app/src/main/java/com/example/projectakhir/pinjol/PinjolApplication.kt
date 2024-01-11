package com.example.projectakhir.pinjol

import android.app.Application
import com.example.projectakhir.data.AppContainer
import com.example.projectakhir.data.PinjolContainer


class PinjolApplication : Application() {
        lateinit var container: AppContainer

        override fun onCreate() {
            super.onCreate()

            container = PinjolContainer()
        }
}