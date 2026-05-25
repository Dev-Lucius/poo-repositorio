package srp.notification;

import java.math.BigDecimal;
import srp.domain.BillingInvoice;

public interface BillingNotifier {
    void notifyIssued(BillingInvoice invoice, BigDecimal total);
}
