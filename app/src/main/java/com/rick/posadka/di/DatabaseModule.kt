package com.rick.posadka.di

import android.content.Context
import com.rick.posadka.data.PosadkaDatabase
import com.rick.posadka.data.PosadkaHoleDao
import com.rick.posadka.data.PosadkaShaftDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providePosadkaDatabase(@ApplicationContext context: Context): PosadkaDatabase {
        return PosadkaDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun providePosadkaHoleDao(posadkaDatabase: PosadkaDatabase): PosadkaHoleDao {
        return posadkaDatabase.posadkaHoleDao()
    }

    @Singleton
    @Provides
    fun providePosadkaShaftDao(posadkaDatabase: PosadkaDatabase): PosadkaShaftDao {
        return posadkaDatabase.posadkaShaftDao()
    }
}