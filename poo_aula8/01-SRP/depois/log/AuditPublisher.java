package srp.log;

import java.math.BigDecimal;
import srp.domain.BillingInvoice;

public interface AuditPublisher {
    void publishIssued(BillingInvoice invoice, BigDecimal total);
}
