package com.billyluisneedham.taxassistant.expenses

import androidx.room.Dao
import androidx.room.Query
import com.billyluisneedham.taxassistant.data.BaseDao
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao: BaseDao<Expense> {
    @Query("SELECT * from expenses")
    fun getAll(): Flow<List<Expense>>

    @Query("DELETE from expenses")
    fun deleteAll()
}