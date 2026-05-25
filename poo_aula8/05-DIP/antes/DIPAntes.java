import java.math.BigDecimal;

class OracleCustomerRepository {
    public CustomerProfile findByDocument(String document) {
        System.out.println("SQL(Oracle)> SELECT * FROM customers WHERE document='" + document + "'");
        return new CustomerProfile(document, "CORPORATE", new BigDecimal("1250000.00"));
    }
}

class SoapCreditBureauClient {
    public int fetchCreditScore(String document) {
        System.out.println("SOAP> Consultando bureau para documento " + document);
        return 712;
    }
}

class SmtpDecisionNotifier {
    public void send(String document, String decision) {
        System.out.println("SMTP> Enviando decisao para " + document + ": " + decision);
    }
}

class CustomerProfile {
    private final String document;
    private final String segment;
    private final BigDecimal monthlyRevenue;

    CustomerProfile(String document, String segment, BigDecimal monthlyRevenue) {
        this.document = document;
        this.segment = segment;
        this.monthlyRevenue = monthlyRevenue;
    }

    public String getDocument() {
        return document;
    }

    public String getSegment() {
        return segment;
    }

    public BigDecimal getMonthlyRevenue() {
        return monthlyRevenue;
    }
}

class CreditApprovalService {
    private final OracleCustomerRepository customerRepository = new OracleCustomerRepository();
    private final SoapCreditBureauClient bureauClient = new SoapCreditBureauClient();
    private final SmtpDecisionNotifier notifier = new SmtpDecisionNotifier();

    public void evaluate(String document, BigDecimal requestedValue) {
        CustomerProfile profile = customerRepository.findByDocument(document);
        int score = bureauClient.fetchCreditScore(document);

        String decision;
        if ("CORPORATE".equals(profile.getSegment())
                && score >= 700
                && requestedValue.compareTo(profile.getMonthlyRevenue().multiply(new BigDecimal("2.5"))) <= 0) {
            decision = "APPROVED";
        } else {
            decision = "REJECTED";
        }

        notifier.send(document, decision);
    }
}

public class DIPAntes {
    public static void main(String[] args) {
        CreditApprovalService service = new CreditApprovalService();
        service.evaluate("12.345.678/0001-99", new BigDecimal("2000000.00"));
    }
}
