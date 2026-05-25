package dip.infrastructure.notification;

import dip.contracts.CreditDecisionNotifier;

public class EventBusCreditDecisionNotifier implements CreditDecisionNotifier {
    @Override
    public void notifyDecision(String document, String decision) {
        System.out.println("EVENT> topic=credit.decision document=" + document + " decision=" + decision);
    }
}
