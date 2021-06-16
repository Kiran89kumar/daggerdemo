package com.kiran.daggerpoc.ui.di

import androidx.lifecycle.ViewModelProvider
import com.kiran.daggerpoc.di.ActivityScope
import com.kiran.daggerpoc.di.module.UseCaseModule
import com.kiran.daggerpoc.ui.MainActivity
import com.kiran.daggerpoc.ui.MainViewModel
import com.kiran.data.db.BlogDAO
import com.kiran.data.db.BlogDBMapper
import com.kiran.data.network.BlogAPI
import com.kiran.data.network.BlogNetworkMapper
import com.kiran.data.repository.*
import com.kiran.domain.repository.BlogRepository
import com.kiran.domain.usecases.BlogUseCase
import dagger.Module
import dagger.Provides

@Module(includes = [UseCaseModule::class])
class MainActivityModule {

    @Provides
    @ActivityScope
    fun getViewModel(
        activity: MainActivity,
        mainViewModelProviderFactory: MainViewModelProviderFactory
    ): MainViewModel = ViewModelProvider(activity, mainViewModelProviderFactory).get(
        MainViewModel::class.java
    )
}