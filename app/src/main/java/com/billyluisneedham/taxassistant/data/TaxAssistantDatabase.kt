package com.billyluisneedham.taxassistant.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.billyluisneedham.taxassistant.expenses.Expense
import com.billyluisneedham.taxassistant.expenses.ExpenseDao

@Database(entities = [Expense::class], version = 1)
abstract class TaxAssistantDatabase : RoomDatabase() {
    abstract fun expensesDao(): ExpenseDao

    companion object {
        private const val DATABASE_NAME = "Tax-Assistant-Database.db"

        @Volatile
        private var instance: TaxAssistantDatabase? = null

        fun getInstance(context: Context): TaxAssistantDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): TaxAssistantDatabase {
            return Room.databaseBuilder(context, TaxAssistantDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}