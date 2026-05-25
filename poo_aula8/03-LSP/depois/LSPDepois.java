package lsp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lsp.application.CustodyFeeCollector;
import lsp.audit.BalanceAuditService;
import lsp.domain.BalanceView;
import lsp.domain.ComplianceRestrictedAccount;
import lsp.domain.DebitCapableAccount;
import lsp.domain.TradingAccount;

public class LSPDepois {
    public static void main(String[] args) {
        List<DebitCapableAccount> debitAccounts = Arrays.asList(
                new TradingAccount(new BigDecimal("1000.00")),
                new TradingAccount(new BigDecimal("3000.00"))
        );

        new CustodyFeeCollector().collect(debitAccounts, new BigDecimal("50.00"));

        List<BalanceView> allAccounts = Arrays.asList(
                debitAccounts.get(0),
                debitAccounts.get(1),
                new ComplianceRestrictedAccount(new BigDecimal("5000.00"))
        );

        new BalanceAuditService().printBalances(allAccounts);
    }
}
