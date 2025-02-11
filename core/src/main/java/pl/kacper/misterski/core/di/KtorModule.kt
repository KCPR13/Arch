package pl.kacper.misterski.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging

@Module
@InstallIn(SingletonComponent::class)
object KtorModule {

    @Provides
    fun provideHttpClient() = HttpClient() {
        install(Logging) {
            level = LogLevel.BODY
        }
    }
}