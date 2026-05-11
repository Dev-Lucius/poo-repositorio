package exemplo1;

import java.util.ArrayList;
import java.util.List;

//  A IDEIA É QUE BASES DIFERENTES FUNCIONAM DE MANEIRAS DIFERENTES, SQL, FORMATO DOS DADOS, O QUE DA PARA FAZER COM AS ESPECIFICIDADES DE CADA CLASSE
// O NOSSO EXEMPLO ELAS SAO IGUAIS PELA SIMPLICIDADE E POR NAO SER O FOCO DA AULA
public class BaseFuncionarios implements IGerarRelatorio {
    
    private List<Funcionario> base;

    BaseFuncionarios() {
        this.base = new ArrayList<>();
    }

    public void addFuncionario(Funcionario func) {
        this.base.add(func);
    }

    // COMO A CLASSE IMPLEMENA A INTERFACE QUE GERA RELATORIO, NAO PRECISO MAIS DAR ACESSO A LISTA DE FUNCIONARIO VIA GET.
    // MAIS PROTECAO, MENOS ACOPLAMENTO
    // public List<Funcionario> getFuncionarios() {
    //     return this.base;
    // }

    @Override
    public void gerarRelatorio() {
        System.out.println(" RELATORIO DE PESSOAL ");
        for (Funcionario f : base) {
            System.out.println(f);
        }
    }

}
