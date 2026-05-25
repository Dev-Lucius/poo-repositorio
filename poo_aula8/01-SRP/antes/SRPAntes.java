import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

class Invoice {
    private final String id;
    private final String customerEmail;
    private final BigDecimal amount;
    private final LocalDate issueDate;

    Invoice(String customerEmail, BigDecimal amount) {
        this.id = UUID.randomUUID().toString();
        this.customerEmail = customerEmail;
        this.amount = amount;
        this.issueDate = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }
}

class InvoiceProcessor {
    public void process(Invoice invoice) {
        if (invoice.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor da fatura invalido");
        }

        if (!invoice.getCustomerEmail().contains("@")) {
            throw new IllegalArgumentException("E-mail do cliente invalido");
        }

        BigDecimal tax = invoice.getAmount().multiply(new BigDecimal("0.12"));
        BigDecimal total = invoice.getAmount().add(tax);

        System.out.println("SQL> INSERT INTO invoices(id, amount, tax, total, issue_date) VALUES ('"
                + invoice.getId() + "', " + invoice.getAmount() + ", " + tax + ", " + total + ", '"
                + invoice.getIssueDate() + "')");

        System.out.println("EMAIL> Para: " + invoice.getCustomerEmail()
                + " | Assunto: Fatura emitida | Total: " + total);

        System.out.println("AUDIT> invoiceId=" + invoice.getId() + " event=INVOICE_ISSUED total=" + total);
    }
}

public class SRPAntes {
    public static void main(String[] args) {
        Invoice invoice = new Invoice("financeiro@cliente.com", new BigDecimal("25000.00"));
        InvoiceProcessor processor = new InvoiceProcessor();
        processor.process(invoice);
    }
}
