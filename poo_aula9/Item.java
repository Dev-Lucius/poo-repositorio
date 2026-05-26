import java.math.BigDecimal;

public class Item {
    
    // TERCEIRA REGRA - ENCAPSULAR TIPOS PRIMITIVOS
    private Dinheiro valor;
    private String nome;

    public Item(String nome, Dinheiro valor) {
        this.nome = nome;
        this.valor = valor;
    }

    
    public BigDecimal getValor() {
        return valor.getValor();
    }

    public String getNome() {
        return nome;
    }

}
