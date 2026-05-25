package dip.infrastructure.provider;

import dip.contracts.CreditScoreProvider;

public class RestCreditScoreProvider implements CreditScoreProvider {
    @Override
    public int fetchScore(String document) {
        System.out.println("REST> GET /credit-score?document=" + document);
        return 712;
    }
}
