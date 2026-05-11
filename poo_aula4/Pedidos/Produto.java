package Pedidos;

public class Produto {
    
    private String nome;
    private float preco;
    private float percentualDesconto;

    public Produto(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
        percentualDesconto = 0;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco * (1-percentualDesconto/100);
    }

    // VS CODE -> BOTAO DIREITO -> SOURCE ACTIONS -> GENERATE TOSTRING
    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", preco=" + getPreco() + "]";
    }

    public void addPercentualDesconto(float percentual) {
        this.percentualDesconto = percentual;
    }

    
}