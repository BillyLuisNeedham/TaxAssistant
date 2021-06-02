package com.billyluisneedham.taxassistant.expenses

import kotlinx.coroutines.flow.Flow

class ExpenseRepository(private val dao: ExpenseDao) {

    fun getAllExpenses(): Flow<List<Expense>> {
        return dao.getAll()
    }

    fun createExpense(expense: Expense) {

    }
}