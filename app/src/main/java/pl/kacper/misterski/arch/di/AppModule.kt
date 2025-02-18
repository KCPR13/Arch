package pl.kacper.misterski.arch.di

import android.content.Context
import android.location.LocationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppLocationManagerImpl(@ApplicationContext context: Context) =
        pl.kacper.misterski.arch.util.managers.AppLocationManagerImpl(
            context.getSystemService(
                LocationManager::class.java
            ) as LocationManager
        )
}