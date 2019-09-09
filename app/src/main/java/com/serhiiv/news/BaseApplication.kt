package com.serhiiv.news

import com.serhiiv.news.di.App
import com.serhiiv.news.di.AppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class BaseApplication : DaggerApplication(), App {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return AppComponent.Initializer.init(this)
    }
}
