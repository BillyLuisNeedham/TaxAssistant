package com.billyluisneedham.taxassistant.expenses.all

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.billyluisneedham.taxassistant.expenses.ExpenseRepository
import com.billyluisneedham.taxassistant.testutils.mocks.MockExpense
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AllExpensesFragmentScenarioTest {

    companion object {

    }

    private val mockExpenseRepository = mockk<ExpenseRepository>()

    private lateinit var allExpensesHeader: String

    @Before
    fun setUp() {

    }

    private fun setUpTestThatReturnsAnExpense() {
        val flow = flow {
            emit(listOf(MockExpense.expense))
        }

        every {
            mockExpenseRepository.getAllExpenses()
        } returns flow

        launchFragmentInContainer<AllExpensesFragment>()
    }

    @Test
    fun displaysNamesOfAllExpensesFetchedFromRepository_expenseExistsInRepository_namePropertyOfExpenseDisplayed() {
        setUpTestThatReturnsAnExpense()

        onView(withText(MockExpense.expense.name))
            .check(matches(isDisplayed()))
    }



}