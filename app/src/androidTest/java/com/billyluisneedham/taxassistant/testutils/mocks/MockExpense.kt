package com.billyluisneedham.taxassistant.testutils.mocks

import com.billyluisneedham.taxassistant.expenses.Expense

class MockExpense {
    companion object {
        val expense = Expense(
            expenseId = 1,
            name = "test expense",
            dateTimeStamp = 12345,
            amount = 58.33,
            receiptUrl = "www.test.com",
            notes = "test notes"
        )
    }
}
