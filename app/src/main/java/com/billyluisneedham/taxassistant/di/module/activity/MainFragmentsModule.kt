package com.billyluisneedham.taxassistant.di.module.activity

import com.billyluisneedham.taxassistant.di.module.fragment.AllExpensesModule
import com.billyluisneedham.taxassistant.expenses.all.AllExpensesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentsModule {

    @ContributesAndroidInjector(modules = [AllExpensesModule::class])
    abstract fun contributeAllExpensesFragment(): AllExpensesFragment
}
