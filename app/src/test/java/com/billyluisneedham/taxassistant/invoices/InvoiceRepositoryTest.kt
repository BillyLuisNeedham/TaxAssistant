package com.billyluisneedham.taxassistant.invoices

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class InvoiceRepositoryTest {

    private lateinit var invoiceRepository: InvoiceRepository
    private val mockDao: InvoiceDao = mockk()
    private val invoice = Invoice(
        invoiceId = 1,
        refNumber = "test ref number",
        nameOfPersonInvoiced = "test name",
        invoiceDateTimeStamp = 12345,
        amount = 58.33,
        invoiceUrl = "www.test.com"
    )

    @Before
    fun setUp() {
        invoiceRepository = InvoiceRepository(mockDao)
    }

    @Test
    fun getAllInvoicesReturnsAllInvoicesInDatabase() = runBlocking {
        val flow = flow {
            emit(listOf(invoice))
        }

        every {
            mockDao.getAll()
        } returns flow

        val result = invoiceRepository.getAllInvoices().first()

        assertThat(result, `is`(listOf(invoice)))
    }

    @Test
    fun createInvoiceCreatesInvoiceInDatabase() = runBlocking {
        coEvery {
            mockDao.insert(invoice)
        } returns Unit

        invoiceRepository.createInvoice(invoice)

        coVerify {
            mockDao.insert(invoice)
        }
    }
}