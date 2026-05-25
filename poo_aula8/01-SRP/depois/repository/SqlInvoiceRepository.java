package srp.repository;

import java.math.BigDecimal;
import srp.domain.BillingInvoice;

public class SqlInvoiceRepository implements InvoiceRepository {
    @Override
    public void save(BillingInvoice invoice, BigDecimal tax, BigDecimal total) {
        System.out.println("SQL> INSERT INTO invoices(id, amount, tax, total, issue_date) VALUES ('"
                + invoice.getId() + "', " + invoice.getAmount() + ", " + tax + ", " + total + ", '"
                + invoice.getIssueDate() + "')");
    }
}
