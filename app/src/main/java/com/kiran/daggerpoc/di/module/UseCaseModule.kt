package com.kiran.daggerpoc.di.module

import com.kiran.daggerpoc.di.ActivityScope
import com.kiran.data.db.BlogDAO
import com.kiran.data.db.BlogDBMapper
import com.kiran.data.network.BlogAPI
import com.kiran.data.network.BlogNetworkMapper
import com.kiran.data.repository.*
import com.kiran.domain.repository.BlogRepository
import com.kiran.domain.usecases.BlogUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    @ActivityScope
    fun providesBlogsNetworkDataSource(blogAPI: BlogAPI, blogNetworkMapper: BlogNetworkMapper): BlogsNetworkDataSource =
        BlogsNetworkDataSourceImpl(blogAPI, blogNetworkMapper)

    @Provides
    @ActivityScope
    fun providesBlogsDBDataSource(blogDAO: BlogDAO, blogDBMapper: BlogDBMapper): BlogsDBDataSource =
        BlogsDBDataSourceImpl(blogDAO, blogDBMapper)

    @Provides
    @ActivityScope
    fun providesBlogRepository(blogsNetworkDataSource: BlogsNetworkDataSource, blogsDBDataSource: BlogsDBDataSource): BlogRepository =
        BlogRepositoryImpl(blogsNetworkDataSource, blogsDBDataSource)

    @Provides
    @ActivityScope
    fun provideDataUseCase(
        blogRepository: BlogRepository
    ): BlogUseCase {
        return BlogUseCase(blogRepository)
    }
}