package com.billyluisneedham.taxassistant.expenses

import androidx.room.Dao
import androidx.room.Query
import com.billyluisneedham.taxassistant.data.BaseDao

@Dao
interface ExpenseDao: BaseDao<Expense> {
    @Query("SELECT * from expenses")
    fun getAll(): List<Expense>

    @Query("DELETE from expenses")
    fun deleteAll()
}