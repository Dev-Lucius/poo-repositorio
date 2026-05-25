package srp.validation;

import java.math.BigDecimal;
import srp.domain.BillingInvoice;

public class BasicInvoiceValidator implements InvoiceValidator {
    @Override
    public void validate(BillingInvoice invoice) {
        if (invoice.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor da fatura invalido");
        }
        if (!invoice.getCustomerEmail().contains("@")) {
            throw new IllegalArgumentException("E-mail do cliente invalido");
        }
    }
}
