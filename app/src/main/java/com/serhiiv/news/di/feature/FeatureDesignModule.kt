package com.serhiiv.news.di.feature

import com.serhiiv.news.di.PerFragment
import com.serhiiv.news.ui.design.DesignFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FeatureDesignModule {
    @PerFragment
    @ContributesAndroidInjector
    fun contributeDesignFragment(): DesignFragment
}
