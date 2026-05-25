package lsp.domain;

import java.math.BigDecimal;

public class ComplianceRestrictedAccount implements BalanceView {
    private final BigDecimal balance;

    public ComplianceRestrictedAccount(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public BigDecimal getBalance() { return balance; }
}
