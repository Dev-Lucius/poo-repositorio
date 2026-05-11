package exemplo1;

import java.util.ArrayList;
import java.util.List;

import exemplo1.relatorios.GeradorRelatorios;

public class Main {
    public static void main(String[] args) {
        
        // BASES DE DADOS NA MINHA APLICACAO
        // no sistema existe um botao para EXPORTAR base de dados

        BaseFuncionarios bFunc = new BaseFuncionarios();
        bFunc.addFuncionario(new Funcionario("christian", 10000));
        bFunc.addFuncionario(new Funcionario("janaiton", 8000));
        bFunc.addFuncionario(new Funcionario("tiago", 7000));
        
        // GeradorRelatorios gerador = new GeradorRelatorios();
        // gerador.gerarRelatorio(bFunc);

        bFunc.gerarRelatorio();

        BaseFinanceira bFinanceira = new BaseFinanceira();
        bFinanceira.addDados(new RelatorioFinanceiro("TI", "13/04/2026", 20000));

        bFinanceira.gerarRelatorio();
        // gerador.gerarRelatorio(bFinanceira);

        List<IGerarRelatorio> todosRelatorios = new ArrayList<>();
        todosRelatorios.add(bFunc);
        todosRelatorios.add(bFinanceira);

        for (IGerarRelatorio iGerarRelatorio : todosRelatorios) {
            iGerarRelatorio.gerarRelatorio();
        }
        
    }
}
