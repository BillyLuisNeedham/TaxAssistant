package com.billyluisneedham.taxassistant.expenses.all

import com.billyluisneedham.taxassistant.expenses.ExpenseRepository
import com.billyluisneedham.taxassistant.mocks.MockExpenseUnit
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class AllExpensesViewModelTest {

    private val mockExpenseRepository = mockk<ExpenseRepository>()

    private val expenseList = listOf(
        MockExpenseUnit.expense,
        MockExpenseUnit.expense.copy(expenseId = 2)
    )

    @Before
    fun setUp() {

    }

    @Test
    fun getsAllExpensesViaRepositoryOnInit_expenseRepositoryReturnsExpenses_expensesAreWithinViewModel() {
        val flow = flow {
            emit(expenseList)
        }

        every {
            mockExpenseRepository.getAllExpenses()
        } returns flow

        val viewModel = AllExpensesViewModel(mockExpenseRepository)

        assertThat(viewModel.expenses, `is`(flow))

    }
}