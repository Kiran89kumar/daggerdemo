package com.kiran.daggerpoc.di

import com.kiran.daggerpoc.ui.Application
import com.kiran.daggerpoc.di.module.ActivityBuilderModule
import com.kiran.daggerpoc.di.module.AppModule
import com.kiran.daggerpoc.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<Application> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

   /* @Component.Factory
    interface Factory : AndroidInjector.Factory<Application>*/
}