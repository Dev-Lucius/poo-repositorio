import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// PEDIDO ITENS VIROU PARTE DO DOMINIO DA MINHA APLICACAO
public class PedidoItens {
    private List<Item> itens;

    public PedidoItens() {
        this.itens = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.itens.add(item);
    }

    public int quantosItens() {
        return this.itens.size();
    }

    public BigDecimal calculaTotal() {
        BigDecimal total = new BigDecimal(0.0f);
        for (Item item : itens) {
            total = total.add(item.getValor());
        }
        return total;
    }

    public List<Item> getItens() {
        return itens;
    }
}
