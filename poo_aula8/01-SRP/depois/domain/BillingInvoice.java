package srp.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class BillingInvoice {
    private final String id;
    private final String customerEmail;
    private final BigDecimal amount;
    private final LocalDate issueDate;

    public BillingInvoice(String customerEmail, BigDecimal amount) {
        this.id = UUID.randomUUID().toString();
        this.customerEmail = customerEmail;
        this.amount = amount;
        this.issueDate = LocalDate.now();
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public BigDecimal getAmount() { return amount; }
    public LocalDate getIssueDate() { return issueDate; }
}
