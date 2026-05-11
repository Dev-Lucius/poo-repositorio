package poo_ex13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrinho {

    /**
     * Composição
     * Itens só existem dentro do carrinho
     * Quando o carrinho é descartado (compra finalizada), os itens vão junto
     * --> Ciclo de vida é compartilhado
     */
    private List<Item> itens;
    private String cliente;
    private int quantidadeItens;

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public String getCliente() {
        return cliente;
    }

    public int getQuantidadeItens() {
        return itens.size();
    }

    public Carrinho(String cliente){
        setCliente(cliente);
        this.itens = new ArrayList<>();
    }

    public void setCliente(String cliente){
        if(cliente == null || cliente.trim().isEmpty()){
            System.out.println("Cliente Inválido");
        } else {
            this.cliente = cliente;
        }
    }

    /**
     * Método para Adicioanr um item ao carrinho
     * Chamado pela loja via adicionarItem()
     * 
     * @param item Item a ser adicioando
    */
    public void adicionarItem(Item item){
        if(item == null){
            System.out.println("Item Inválido");
        } else {
            itens.add(item);
            System.out.println(item.getNome() + " foi adicionado com sucesso ao Carrinho");
        }
    }

    /**
     * CONCEITO — CÁLCULO BASEADO NO ESTADO:
     * O total é calculado percorrendo a lista no momento
     * da chamada — sempre reflete o estado atual do carrinho.
     */
    public double calcularTotal(){
        double total = 0.00;
        for(Item item : itens){
            total += item.getPreco();
        }
        return total;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Carrinho de ").append(cliente).append("\n");
        if(itens.isEmpty()){
            sb.append(" Carrinho Vazio");
        } else {
            for(Item item : itens){
                sb.append("  - ").append(item).append("\n");
            }
            sb.append("  Total: R$ ").append(String.format("%.2f", calcularTotal()));
        }
        return sb.toString();
    }
}
