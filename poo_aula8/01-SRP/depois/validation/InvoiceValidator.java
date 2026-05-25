package srp.validation;

import srp.domain.BillingInvoice;

public interface InvoiceValidator {
    void validate(BillingInvoice invoice);
}
