package lsp.domain;

import java.math.BigDecimal;

public interface DebitCapableAccount extends BalanceView {
    void debit(BigDecimal amount);
    void credit(BigDecimal amount);
}
