package lsp.audit;

import java.util.List;
import lsp.domain.BalanceView;

public class BalanceAuditService {
    public void printBalances(List<BalanceView> accounts) {
        for (BalanceView account : accounts) {
            System.out.println("Saldo atual: " + account.getBalance());
        }
    }
}
