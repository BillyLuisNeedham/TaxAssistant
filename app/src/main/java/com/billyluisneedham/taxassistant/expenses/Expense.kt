package com.billyluisneedham.taxassistant.expenses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "expense_id") val expenseId: Long,
    val name: String,
    @ColumnInfo(name = "date_time_stamp") val dateTimeStamp: Long,
    val amount: Double,
    @ColumnInfo(name = "receipt_url") val receiptUrl: String,
    val notes: String
)
