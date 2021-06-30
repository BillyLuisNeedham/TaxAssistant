package com.billyluisneedham.taxassistant.di.module

import com.billyluisneedham.taxassistant.di.module.activity.ActivityBuildersModule
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule


@Module(
    includes = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        ViewModelFactoryModule::class
    ]
)
class AppModule