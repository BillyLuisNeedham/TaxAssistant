package com.billyluisneedham.taxassistant.invoices

import androidx.room.Dao
import androidx.room.Query
import com.billyluisneedham.taxassistant.data.BaseDao

@Dao
interface InvoiceDao: BaseDao<Invoice> {
    @Query("SELECT * from invoices")
    fun getAll(): List<Invoice>

    @Query("DELETE from invoices")
    fun deleteAll()
}