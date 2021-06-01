package com.billyluisneedham.taxassistant.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.billyluisneedham.taxassistant.expenses.Expense
import com.billyluisneedham.taxassistant.expenses.ExpenseDao

@Database(entities = [Expense::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun expensesDao(): ExpenseDao

    companion object {
        private const val DATABASE_NAME = "AppDatabase"

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}