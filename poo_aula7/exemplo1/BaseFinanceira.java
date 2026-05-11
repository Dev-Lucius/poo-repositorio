package exemplo1;

import java.util.ArrayList;
import java.util.List;

public class BaseFinanceira implements IGerarRelatorio {
 
    private List<RelatorioFinanceiro> base;

    BaseFinanceira() {
        this.base = new ArrayList<>();
    }

    public void addDados(RelatorioFinanceiro func) {
        this.base.add(func);
    }

    // public List<RelatorioFinanceiro> getDados() {
    //     return this.base;
    // }

    @Override
    public void gerarRelatorio() {
        System.out.println(" RELATORIO FINANCEIRA ");
        for (RelatorioFinanceiro f : base) {
            System.out.println(f);
        }
    }
}
