package com.billyluisneedham.taxassistant.expenses.all

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.billyluisneedham.taxassistant.R
import com.billyluisneedham.taxassistant.expenses.ExpenseRepository
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AllExpensesFragmentTest {

    companion object {
        private const val ALL_EXPENSES_HEADER = R.string.all_expenses
    }

    private val mockExpenseRepository = mockk<ExpenseRepository>()

    private lateinit var allExpensesHeader: String

    @Before
    fun setUp() {
        allExpensesHeader = InstrumentationRegistry.getInstrumentation().targetContext.getString(
            ALL_EXPENSES_HEADER
        )

    }

    @Test
    fun displaysCorrectHeader() {
        launchFragmentInContainer<AllExpensesFragment>()

        onView(withText(allExpensesHeader))
            .check(matches(isDisplayed()))
    }

}