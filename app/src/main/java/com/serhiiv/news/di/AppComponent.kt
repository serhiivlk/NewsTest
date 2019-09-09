package com.serhiiv.news.di

import com.serhiiv.news.BaseApplication
import com.serhiiv.news.di.feature.FeatureMainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        FeatureMainModule::class,
        DataModule::class
    ]
)
@PerApplication
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): AppComponent
    }

    object Initializer {
        @JvmStatic
        fun init(app: App): AppComponent {
            return DaggerAppComponent.factory().create(app)
        }
    }
}
