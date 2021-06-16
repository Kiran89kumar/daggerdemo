package com.kiran.daggerpoc.di.module

import android.content.Context
import androidx.room.Room
import com.kiran.daggerpoc.ui.Application
import com.kiran.data.db.BlogDAO
import com.kiran.data.db.BlogDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun getString(): String = "This is an example!"

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application.applicationContext

    @Singleton
    @Provides
    fun provideBlogDb(context: Context): BlogDB {
        return Room
            .databaseBuilder(
                context,
                BlogDB::class.java,
                BlogDB.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBlogDAO(blogDB: BlogDB): BlogDAO {
        return blogDB.BlogDAO()
    }
}