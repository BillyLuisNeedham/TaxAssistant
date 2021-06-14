package com.billyluisneedham.taxassistant.invoices

import androidx.room.Dao
import androidx.room.Query
import com.billyluisneedham.taxassistant.database.BaseDao
import kotlinx.coroutines.flow.Flow

@Dao
interface InvoiceDao: BaseDao<Invoice> {
    @Query("SELECT * from invoices")
    fun getAll(): Flow<List<Invoice>>

    @Query("DELETE from invoices")
    fun deleteAll()
}