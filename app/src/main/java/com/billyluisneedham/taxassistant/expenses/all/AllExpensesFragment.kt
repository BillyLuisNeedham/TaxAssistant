package com.billyluisneedham.taxassistant.expenses.all

import androidx.fragment.app.viewModels
import dagger.android.support.DaggerFragment

class AllExpensesFragment: DaggerFragment() {


    private val viewModel by viewModels<AllExpensesViewModel>()
}