package com.billyluisneedham.taxassistant.invoices

import androidx.room.Query
import com.billyluisneedham.taxassistant.data.BaseDao

interface InvoiceDao: BaseDao<Invoice> {
    @Query("SELECT * from invoices")
    fun getAll(): List<Invoice>

    @Query("DELETE from invoices")
    fun deleteAll()
}