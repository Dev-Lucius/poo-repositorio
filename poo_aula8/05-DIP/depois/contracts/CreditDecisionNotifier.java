package dip.contracts;

public interface CreditDecisionNotifier {
    void notifyDecision(String document, String decision);
}
