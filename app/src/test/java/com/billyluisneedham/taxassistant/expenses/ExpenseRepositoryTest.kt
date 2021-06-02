package com.billyluisneedham.taxassistant.expenses

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
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
        val flow = flow {
            emit(listOf(expense))
        }

        every {
            mockDao.getAll()
        } returns flow

        val result = expenseRepository.getAllExpenses().first()

        assertThat(result, `is`(listOf(expense)))
    }

    @Test
    fun createExpenseCreatesExpenseInDatabase() = runBlocking {
        coEvery {
            mockDao.insert(expense)
        } returns Unit

        expenseRepository.createExpense(expense)

        coVerify {
            mockDao.insert(expense)
        }
    }
}