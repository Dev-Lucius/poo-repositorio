package lsp.application;

import java.math.BigDecimal;
import java.util.List;
import lsp.domain.DebitCapableAccount;

public class CustodyFeeCollector {
    public void collect(List<DebitCapableAccount> accounts, BigDecimal fee) {
        for (DebitCapableAccount account : accounts) {
            account.debit(fee);
            System.out.println("Taxa debitada. Novo saldo: " + account.getBalance());
        }
    }
}
