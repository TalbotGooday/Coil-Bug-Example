package com.gapps.coilbugexample.application

import android.app.Application
import com.gapps.coilbugexample.coil.initCoil

class App: Application() {
	override fun onCreate() {
		super.onCreate()
		initCoil(this)
	}
}