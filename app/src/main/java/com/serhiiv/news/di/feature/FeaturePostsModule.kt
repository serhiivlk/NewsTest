package com.serhiiv.news.di.feature

import com.serhiiv.news.di.PerFragment
import com.serhiiv.news.ui.posts.PostsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FeaturePostsModule {
    @PerFragment
    @ContributesAndroidInjector
    fun contributePostsFragment(): PostsFragment
}
