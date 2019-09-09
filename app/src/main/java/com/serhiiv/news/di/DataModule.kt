package com.serhiiv.news.di

import com.serhiiv.news.data.remote.ApiClient
import com.serhiiv.news.data.remote.TestApiService
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideTestApiService(): TestApiService {
        return ApiClient.makeTestApiService()
    }
}
