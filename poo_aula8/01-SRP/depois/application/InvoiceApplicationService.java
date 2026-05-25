package srp.application;

import java.math.BigDecimal;
import srp.domain.BillingInvoice;
import srp.log.AuditPublisher;
import srp.notification.BillingNotifier;
import srp.policy.TaxPolicy;
import srp.repository.InvoiceRepository;
import srp.validation.InvoiceValidator;

public class InvoiceApplicationService {
    private final InvoiceValidator validator;
    private final TaxPolicy taxPolicy;
    private final InvoiceRepository repository;
    private final BillingNotifier notifier;
    private final AuditPublisher auditPublisher;

    public InvoiceApplicationService(
            InvoiceValidator validator,
            TaxPolicy taxPolicy,
            InvoiceRepository repository,
            BillingNotifier notifier,
            AuditPublisher auditPublisher
    ) {
        this.validator = validator;
        this.taxPolicy = taxPolicy;
        this.repository = repository;
        this.notifier = notifier;
        this.auditPublisher = auditPublisher;
    }

    public void issue(BillingInvoice invoice) {
        validator.validate(invoice);
        BigDecimal tax = taxPolicy.calculateTax(invoice);
        BigDecimal total = invoice.getAmount().add(tax);
        repository.save(invoice, tax, total);
        notifier.notifyIssued(invoice, total);
        auditPublisher.publishIssued(invoice, total);
    }
}
