package com.serhiiv.news.di.feature

import com.serhiiv.news.ui.main.MainActivity
import com.serhiiv.news.di.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FeatureMainModule {
    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            FeaturePostsModule::class,
            FeatureDesignModule::class
        ]
    )
    fun contributeMainActivity(): MainActivity
}
