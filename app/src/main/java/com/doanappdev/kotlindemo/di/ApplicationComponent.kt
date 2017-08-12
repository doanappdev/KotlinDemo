package com.doanappdev.kotlindemo.di

import com.doanappdev.kotlindemo.DemoApplication
import com.doanappdev.kotlindemo.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface ApplicationComponent {
    fun inject(application: DemoApplication)
    fun inject(mainActivity: MainActivity)
}
