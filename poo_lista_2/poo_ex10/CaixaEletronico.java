package poo_ex10;


public class CaixaEletronico {
    private String identificacao;

    public CaixaEletronico(String identicacao){
        this.identificacao = identicacao;
    }

    /**
     * Realizando um Depósito em uma Conta Bancária
     * 
     * Associação - definição
     * CaixaEletronico recebe ContaBancaria como um parâmetro
     * NÃO A CRIA NEM A ARMAZENA 
     * Os dois coexistem de forma independente.
     * 
     * @param Conta Conta que recebe o depósito
     * @param valor Valor a depositar
     */
    public void realizarDeposito(ContaBancaria conta, double valor){
        if(conta == null){
            System.out.println("Conta Não Existe");
        } else {
            System.out.println("\n[" + identificacao + "] Iniciando Depósito");
            conta.depositar(valor); // Delega a operação para a própria contaBancaria
            System.out.println("[" + identificacao + "] Operação Concluída");
        }
    }
}
