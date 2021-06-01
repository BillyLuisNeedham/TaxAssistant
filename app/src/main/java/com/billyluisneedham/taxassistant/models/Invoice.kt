package com.billyluisneedham.taxassistant.models

import androidx.room.Entity

@Entity(tableName = "invoices")
data class Invoice(
    val invoiceId: Long,
    val refNumber: String,
    val whoHasBeenInvoiced: String,
    val invoiceDateTimeStamp: Long,
    val amount: Double,
    val hasBeenPaid: Boolean = false,
    val invoiceUrl: String,
    val notes: String,
)
