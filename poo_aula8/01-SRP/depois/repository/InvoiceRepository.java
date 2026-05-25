package srp.repository;

import java.math.BigDecimal;
import srp.domain.BillingInvoice;

public interface InvoiceRepository {
    void save(BillingInvoice invoice, BigDecimal tax, BigDecimal total);
}
