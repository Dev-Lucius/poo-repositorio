package srp;

import java.math.BigDecimal;
import srp.application.InvoiceApplicationService;
import srp.domain.BillingInvoice;
import srp.log.ConsoleAuditPublisher;
import srp.notification.EmailBillingNotifier;
import srp.policy.DefaultTaxPolicy;
import srp.repository.SqlInvoiceRepository;
import srp.validation.BasicInvoiceValidator;

public class SRPDepois {
    public static void main(String[] args) {
        BillingInvoice invoice = new BillingInvoice("financeiro@cliente.com", new BigDecimal("25000.00"));

        InvoiceApplicationService appService = new InvoiceApplicationService(
                new BasicInvoiceValidator(),
                new DefaultTaxPolicy(),
                new SqlInvoiceRepository(),
                new EmailBillingNotifier(),
                new ConsoleAuditPublisher()
        );

        appService.issue(invoice);
    }
}
