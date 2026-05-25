package lsp.domain;

import java.math.BigDecimal;

public class TradingAccount implements DebitCapableAccount {
    private BigDecimal balance;

    public TradingAccount(BigDecimal initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public BigDecimal getBalance() { return balance; }

    @Override
    public void debit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Debito invalido");
        }
        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        balance = balance.subtract(amount);
    }

    @Override
    public void credit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Credito invalido");
        }
        balance = balance.add(amount);
    }
}
