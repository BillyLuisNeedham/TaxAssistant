package com.billyluisneedham.taxassistant.expenses

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface ExpenseDao {
    @Query("SELECT * from expenses")
    fun getAll(): List<Expense>


    @Insert(onConflict = REPLACE)
    fun insertAll(vararg expense: Expense)

    @Delete
    fun delete(expense: Expense)

    @Query("DELETE from expenses")
    fun deleteAll()
}