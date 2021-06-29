package com.billyluisneedham.taxassistant.expenses.all

import androidx.lifecycle.ViewModel
import com.billyluisneedham.taxassistant.expenses.Expense
import com.billyluisneedham.taxassistant.expenses.ExpenseRepository
import kotlinx.coroutines.flow.Flow

class AllExpensesViewModel(expenseRepository: ExpenseRepository): ViewModel() {

    val expenses: Flow<List<Expense>> = expenseRepository.getAllExpenses()

}
