package com.billyluisneedham.taxassistant.expenses.all

import androidx.lifecycle.ViewModel
import com.billyluisneedham.taxassistant.expenses.Expense
import com.billyluisneedham.taxassistant.expenses.ExpenseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AllExpensesViewModel @Inject constructor(expenseRepository: ExpenseRepository): ViewModel() {

    val expenses: Flow<List<Expense>> = expenseRepository.getAllExpenses()

}
