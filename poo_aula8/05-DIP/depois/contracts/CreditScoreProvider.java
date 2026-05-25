package dip.contracts;

public interface CreditScoreProvider {
    int fetchScore(String document);
}
