package com.billyluisneedham.taxassistant.invoices

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "invoices")
data class Invoice(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "invoice_id") val invoiceId: Long,
    @ColumnInfo(name = "ref_number") val refNumber: String,
    @ColumnInfo(name = "name_of_person_invoiced") val nameOfPersonInvoiced: String,
    @ColumnInfo(name = "invoice_date_time_stamp") val invoiceDateTimeStamp: Long,
    val amount: Double,
    @ColumnInfo(name = "has_been_paid") val hasBeenPaid: Boolean = false,
    @ColumnInfo(name = "invoice_url") val invoiceUrl: String,
    val notes: String? = null,
)
