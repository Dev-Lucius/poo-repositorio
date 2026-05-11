package POO_ex3;

public class EstoqueProduto{
    private String nome;
    private int quantidade;

    public EstoqueProduto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public void entrada(int qtd){
        if(qtd <= 0){
            System.out.println("Valor Inválido");
        } else {
            quantidade = quantidade + qtd;
        }
    }

    public boolean saida(int qtd){
        if(qtd <= 0 || qtd > quantidade){
            System.out.println("Valor Inválido");
            return false;
        } else {
            quantidade = quantidade - qtd;
            return true;
        }
    }

    public String nome() {
        return nome;
    }

    public int quantidadeAtual() {
        return quantidade;
    }
}
