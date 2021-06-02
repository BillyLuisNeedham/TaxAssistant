package com.billyluisneedham.taxassistant.expenses

class ExpenseRepository(private val dao: ExpenseDao) {

    fun getAllExpenses(): List<Expense> {
        return dao.getAll()
    }
}