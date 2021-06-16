package com.kiran.daggerpoc.ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kiran.daggerpoc.ui.MainViewModel
import com.kiran.domain.usecases.BlogUseCase
import javax.inject.Inject
import dagger.Lazy

class MainViewModelProviderFactory @Inject constructor(
    private val useCase: Lazy<BlogUseCase>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        MainViewModel::class.java -> {
            MainViewModel(useCase.get()) as T
        }
        else -> error("Invalid View model request")
    }
}