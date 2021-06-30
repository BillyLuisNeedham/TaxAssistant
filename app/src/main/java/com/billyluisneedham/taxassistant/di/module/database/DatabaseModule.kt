package com.billyluisneedham.taxassistant.di.module.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.billyluisneedham.taxassistant.database.TaxAssistantDatabase
import com.billyluisneedham.taxassistant.expenses.ExpenseDao
import com.billyluisneedham.taxassistant.invoices.InvoiceDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): RoomDatabase {
        return Room.databaseBuilder(
            context, TaxAssistantDatabase::class.java,
            TaxAssistantDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideExpenseDao(database: TaxAssistantDatabase): ExpenseDao {
        return database.getExpensesDao()
    }

    @Singleton
    @Provides
    fun provideInvoiceDao(database: TaxAssistantDatabase): InvoiceDao {
        return database.getInvoiceDao()
    }
}
