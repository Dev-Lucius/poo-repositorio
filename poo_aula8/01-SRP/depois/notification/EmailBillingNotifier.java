package srp.notification;

import java.math.BigDecimal;
import srp.domain.BillingInvoice;

public class EmailBillingNotifier implements BillingNotifier {
    @Override
    public void notifyIssued(BillingInvoice invoice, BigDecimal total) {
        System.out.println("EMAIL> Para: " + invoice.getCustomerEmail()
                + " | Assunto: Fatura emitida | Total: " + total);
    }
}
