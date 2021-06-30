package com.billyluisneedham.taxassistant.di.module.activity

import com.billyluisneedham.taxassistant.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [MainModule::class]
    )
    abstract fun contributesMainActivity(): MainActivity
}
