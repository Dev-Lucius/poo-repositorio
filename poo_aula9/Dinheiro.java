// class value object

import java.math.BigDecimal;

public class Dinheiro {
    
    private BigDecimal valor;

    public Dinheiro(float valor) {
        if (valor < BigDecimal.ZERO.floatValue()) {
            throw new IllegalArgumentException("Valor do dinheiro não pode ser negativo.");
        }
        this.valor = BigDecimal.valueOf(valor);
    }

    public BigDecimal getValor() {
        return valor;
    }

}
