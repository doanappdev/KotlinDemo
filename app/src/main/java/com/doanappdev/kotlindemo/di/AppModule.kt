package com.doanappdev.kotlindemo.di

import android.app.Application
import android.content.Context
import android.location.LocationManager
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * A module for Android specific dependencies
 */
@Module class AppModule(val application: Application) {

    /**
     * Allow the application context to be injected but require that it be annotated with
     * [ForApplication] to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton
    fun provideApplicationContext(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideLocationManager(): LocationManager {
        return application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    @Provides
    @Singleton
    @Named("something")
    fun provideSomething(): String {
        return "something"
    }

    @Provides
    @Singleton
    @Named("somethingElse")
    fun provideSomethingElse(): String {
        return "somethingElse"
    }

}
