package com.billyluisneedham.taxassistant.expenses

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Test

class ExpenseRepositoryTest {
    private lateinit var expenseRepository: ExpenseRepository
    private val mockDao = mockk<ExpenseDao>()
    private val expense = Expense(
        expenseId = 1,
        name = "test expense",
        dateTimeStamp = 12345,
        amount = 58.33,
        receiptUrl = "www.test.com",
        notes = "test notes"
    )

    @Before
    fun setUp() {
        expenseRepository = ExpenseRepository(mockDao)
    }

    @Test
    fun getAllExpensesCallsReturnsAllExpensesInDatabase() = runBlocking {
    coEvery {
        mockDao.getAll()
    } returns listOf(expense)

        val result = expenseRepository.getAllExpenses()

        assertThat(result, `is`(listOf(expense)))
    }
}