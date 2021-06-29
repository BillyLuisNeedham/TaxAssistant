package com.billyluisneedham.taxassistant.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.billyluisneedham.taxassistant.expenses.ExpenseDao
import com.billyluisneedham.taxassistant.invoices.InvoiceDao
import com.billyluisneedham.taxassistant.testutils.mocks.MockExpense
import com.billyluisneedham.taxassistant.testutils.mocks.MockInvoice
import kotlinx.coroutines.flow.firstOrNull
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
    private lateinit var invoiceDao: InvoiceDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, TaxAssistantDatabase::class.java).build()
        expenseDao = db.getExpensesDao()
        invoiceDao = db.getInvoiceDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun writeAndReadExpense() = runBlocking {
        val expense = MockExpense.expense
        expenseDao.insert(expense)
        val expenses = expenseDao.getAll()
        val expenseList = expenses.firstOrNull()
        assertThat(expenseList?.contains(expense), `is`(true))
    }

    @Test
    fun writeAndReadInvoices() = runBlocking {
        val invoice = MockInvoice.invoice
        invoiceDao.insert(invoice)
        val invoices = invoiceDao.getAll()
        val invoiceList = invoices.firstOrNull()
        assertThat(invoiceList?.contains(invoice), `is`(true))
    }
}