package com.billyluisneedham.taxassistant.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.billyluisneedham.taxassistant.expenses.Expense
import com.billyluisneedham.taxassistant.expenses.ExpenseDao
import com.billyluisneedham.taxassistant.invoices.Invoice
import com.billyluisneedham.taxassistant.invoices.InvoiceDao
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
        val expense = Expense(
            expenseId = 1,
            name = "test expense",
            dateTimeStamp = 12345,
            amount = 58.33,
            receiptUrl = "www.test.com",
            notes = "test notes"
        )
        expenseDao.insert(expense)
        val expenses = expenseDao.getAll()
        val expenseList = expenses.firstOrNull()
        assertThat(expenseList?.contains(expense), `is`(true))
    }

    @Test
    fun writeAndReadInvoices() = runBlocking {
        val invoice = Invoice(
            invoiceId = 1,
            refNumber = "test ref number",
            nameOfPersonInvoiced = "test name",
            invoiceDateTimeStamp = 12345,
            amount = 58.33,
            invoiceUrl = "www.test.com"
        )
        invoiceDao.insert(invoice)
        val invoices = invoiceDao.getAll()
        assertThat(invoices.contains(invoice), `is`(true))
    }
}