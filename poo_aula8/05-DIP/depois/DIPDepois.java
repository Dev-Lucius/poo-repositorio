package dip;

import java.math.BigDecimal;
import dip.application.CreditPolicyService;
import dip.infrastructure.notification.EventBusCreditDecisionNotifier;
import dip.infrastructure.provider.RestCreditScoreProvider;
import dip.infrastructure.repository.OracleClientProfileRepository;

public class DIPDepois {
    public static void main(String[] args) {
        CreditPolicyService service = new CreditPolicyService(
                new OracleClientProfileRepository(),
                new RestCreditScoreProvider(),
                new EventBusCreditDecisionNotifier()
        );

        service.evaluate("12.345.678/0001-99", new BigDecimal("2000000.00"));
    }
}
