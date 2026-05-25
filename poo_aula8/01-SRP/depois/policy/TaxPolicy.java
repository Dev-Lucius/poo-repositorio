package srp.policy;

import java.math.BigDecimal;
import srp.domain.BillingInvoice;

public interface TaxPolicy {
    BigDecimal calculateTax(BillingInvoice invoice);
}
