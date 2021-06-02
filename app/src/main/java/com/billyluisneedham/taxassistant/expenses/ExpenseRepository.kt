package com.billyluisneedham.taxassistant.expenses

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class ExpenseRepository(private val dao: ExpenseDao) {

    companion object {
        private const val TAG = "ExpenseRepository"
    }

    fun getAllExpenses(): Flow<List<Expense>> {
        return dao.getAll()
    }

    suspend fun createExpense(expense: Expense) {
        withContext(Dispatchers.IO) {
            try {
                dao.insert(expense)
            } catch (e: Exception) {
                Log.e(TAG, "error within createExpense")
            }
        }
    }
}