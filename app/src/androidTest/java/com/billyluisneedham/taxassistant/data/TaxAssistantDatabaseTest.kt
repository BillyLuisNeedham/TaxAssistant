package com.billyluisneedham.taxassistant.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.billyluisneedham.taxassistant.expenses.Expense
import com.billyluisneedham.taxassistant.expenses.ExpenseDao
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TaxAssistantDatabaseTest {

    private lateinit var db: TaxAssistantDatabase
    private lateinit var expenseDao: ExpenseDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, TaxAssistantDatabase::class.java).build()
        expenseDao = db.getExpensesDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun writeAndReadExpense() = runBlocking {
        val expense = Expense(
            expenseId = 50,
            name = "test expense",
            dateTimeStamp = 12345,
            amount = 58.33,
            receiptUrl = "www.test.com",
            notes = "test notes"
        )
        expenseDao.insert(expense)
        val expenses = expenseDao.getAll()
        assertThat(expenses.contains(expense), `is`(true))
    }
}