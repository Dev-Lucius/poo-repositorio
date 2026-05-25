import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

abstract class SettlementAccount {
    protected BigDecimal balance;

    SettlementAccount(BigDecimal initialBalance) {
        this.balance = initialBalance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void credit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Credito invalido");
        }
        balance = balance.add(amount);
    }

    public void debit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Debito invalido");
        }
        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        balance = balance.subtract(amount);
    }
}

class TradingSettlementAccount extends SettlementAccount {
    TradingSettlementAccount(BigDecimal initialBalance) {
        super(initialBalance);
    }
}

class ComplianceHoldAccount extends SettlementAccount {
    ComplianceHoldAccount(BigDecimal initialBalance) {
        super(initialBalance);
    }

    @Override
    public void debit(BigDecimal amount) {
        throw new UnsupportedOperationException("Conta bloqueada por compliance nao permite debito");
    }
}

class DailySettlementJob {
    public void collectCustodyFee(List<SettlementAccount> accounts, BigDecimal fee) {
        for (SettlementAccount account : accounts) {
            account.debit(fee);
            System.out.println("Taxa debitada. Novo saldo: " + account.getBalance());
        }
    }
}

public class LSPAntes {
    public static void main(String[] args) {
        List<SettlementAccount> accounts = Arrays.asList(
                new TradingSettlementAccount(new BigDecimal("1000.00")),
                new ComplianceHoldAccount(new BigDecimal("5000.00"))
        );

        DailySettlementJob job = new DailySettlementJob();
        job.collectCustodyFee(accounts, new BigDecimal("50.00")); // Quebra em runtime para ComplianceHoldAccount.
    }
}
