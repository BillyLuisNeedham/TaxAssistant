package com.billyluisneedham.taxassistant.invoices

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class InvoiceRepository(private val dao: InvoiceDao) {

    companion object {
        private const val TAG = "InvoiceRepository"
    }

    fun getAllInvoices(): Flow<List<Invoice>> {
        return dao.getAll()
    }

    suspend fun createInvoice(invoice: Invoice) {
        withContext(Dispatchers.IO) {
            try {
                dao.insert(invoice)
            } catch (e: Exception) {
                Log.e(TAG, "error within createInvoice")
            }
        }
    }

}