package com.billyluisneedham.taxassistant.testutils.mocks

import com.billyluisneedham.taxassistant.invoices.Invoice

class MockInvoice {
    companion object {
        val invoice = Invoice(
            invoiceId = 1,
            refNumber = "test ref number",
            nameOfPersonInvoiced = "test name",
            invoiceDateTimeStamp = 12345,
            amount = 58.33,
            invoiceUrl = "www.test.com"
        )
    }
}