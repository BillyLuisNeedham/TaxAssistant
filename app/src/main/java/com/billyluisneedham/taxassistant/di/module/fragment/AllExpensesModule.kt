package com.billyluisneedham.taxassistant.di.module.fragment

import androidx.lifecycle.ViewModel
import com.billyluisneedham.taxassistant.di.ViewModelKey
import com.billyluisneedham.taxassistant.expenses.all.AllExpensesViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [AllExpensesModule.ViewModelModule::class])
class AllExpensesModule {

    @Provides
    internal fun provideSomeString(): String = "Hello World"

    @Module
    internal abstract class ViewModelModule {
        @Binds
        @IntoMap
        @ViewModelKey(AllExpensesViewModel::class)
        internal abstract fun bindAllExpensesViewModel(viewModel: AllExpensesViewModel): ViewModel
    }

}
