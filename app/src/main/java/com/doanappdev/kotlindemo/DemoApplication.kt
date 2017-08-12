package com.doanappdev.kotlindemo

import android.app.Application
import com.doanappdev.kotlindemo.di.AppModule
import com.doanappdev.kotlindemo.di.ApplicationComponent
import com.doanappdev.kotlindemo.di.DaggerApplicationComponent
import com.doanappdev.kotlindemo.di.NetworkModule

class DemoApplication : Application() {
    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    //@Inject lateinit var locationManager: LocationManager

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()

        // if we want to inject object into this class uncomment this
        //appComponent.inject(this)
    }
}
