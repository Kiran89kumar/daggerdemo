package com.kiran.daggerpoc.di.module

import com.kiran.daggerpoc.MainActivity2
import com.kiran.daggerpoc.di.ActivityScope
import com.kiran.daggerpoc.ui.MainActivity
import com.kiran.daggerpoc.ui.di.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun provideMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun provideMainActivity2(): MainActivity2

    /*companion object {
        @Provides
        fun getString(): String = "This is an example!"
    }
    //Created App Module.
    */
}