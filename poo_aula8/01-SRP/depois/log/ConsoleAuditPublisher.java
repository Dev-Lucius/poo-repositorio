package srp.log;

import java.math.BigDecimal;
import srp.domain.BillingInvoice;

public class ConsoleAuditPublisher implements AuditPublisher {
    @Override
    public void publishIssued(BillingInvoice invoice, BigDecimal total) {
        System.out.println("AUDIT> invoiceId=" + invoice.getId() + " event=INVOICE_ISSUED total=" + total);
    }
}
