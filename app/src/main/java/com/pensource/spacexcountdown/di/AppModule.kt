package com.pensource.spacexcountdown.di

import com.pensource.spacexcountdown.data.source.AppDataSource
import com.pensource.spacexcountdown.data.source.AppRepository
import com.pensource.spacexcountdown.data.source.DefaultAppRepository
import com.pensource.spacexcountdown.data.source.local.LocalAppDataSource
import com.pensource.spacexcountdown.data.source.remote.RemoteAppDataSource
import com.pensource.spacexcountdown.data.source.remote.Service
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class LocalAppDataSourceAnnotation

@Qualifier
annotation class RemoteAppDataSourceAnnotation

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideAppRepository(
        @LocalAppDataSourceAnnotation localAppDataSource: AppDataSource,
        @RemoteAppDataSourceAnnotation remoteAppDataSource: AppDataSource
    ): AppRepository {
        return DefaultAppRepository(
            localAppDataSource,
            remoteAppDataSource
        )
    }

    @LocalAppDataSourceAnnotation
    @Singleton
    @Provides
    fun provideLocalAppDataSource(): AppDataSource {
        return LocalAppDataSource()
    }

    @RemoteAppDataSourceAnnotation
    @Singleton
    @Provides
    fun provideRemoteAppDataSource(
        service: Service,
        dispatcher: CoroutineDispatcher
    ): AppDataSource {
        return RemoteAppDataSource(
            service,
            dispatcher
        )
    }

    @Singleton
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}