package com.kiran.daggerpoc.ui

import com.kiran.daggerpoc.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class Application: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = injector

    private val injector by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}

