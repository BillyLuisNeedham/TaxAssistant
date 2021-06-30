package com.billyluisneedham.taxassistant.di.module

import com.billyluisneedham.taxassistant.di.module.activity.ActivityBuildersModule
import com.billyluisneedham.taxassistant.di.module.database.DatabaseModule
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule


@Module(
    includes = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        ViewModelFactoryModule::class,
        DatabaseModule::class
    ]
)
class AppModule