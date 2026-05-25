package srp.policy;

import java.math.BigDecimal;
import srp.domain.BillingInvoice;

public class DefaultTaxPolicy implements TaxPolicy {
    @Override
    public BigDecimal calculateTax(BillingInvoice invoice) {
        return invoice.getAmount().multiply(new BigDecimal("0.12"));
    }
}
