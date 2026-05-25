package dip.application;

import java.math.BigDecimal;
import dip.contracts.ClientProfileRepository;
import dip.contracts.CreditDecisionNotifier;
import dip.contracts.CreditScoreProvider;
import dip.domain.ClientProfile;

public class CreditPolicyService {
    private final ClientProfileRepository profileRepository;
    private final CreditScoreProvider scoreProvider;
    private final CreditDecisionNotifier notifier;

    public CreditPolicyService(
            ClientProfileRepository profileRepository,
            CreditScoreProvider scoreProvider,
            CreditDecisionNotifier notifier
    ) {
        this.profileRepository = profileRepository;
        this.scoreProvider = scoreProvider;
        this.notifier = notifier;
    }

    public void evaluate(String document, BigDecimal requestedValue) {
        ClientProfile profile = profileRepository.findByDocument(document);
        int score = scoreProvider.fetchScore(document);

        String decision;
        if ("CORPORATE".equals(profile.getSegment())
                && score >= 700
                && requestedValue.compareTo(profile.getMonthlyRevenue().multiply(new BigDecimal("2.5"))) <= 0) {
            decision = "APPROVED";
        } else {
            decision = "REJECTED";
        }

        notifier.notifyDecision(document, decision);
    }
}
