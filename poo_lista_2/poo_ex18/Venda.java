package poo_ex18;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private Cliente cliente;
    private List<Produto> produtos;
    private String observacao;

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getObservacao() {
        return observacao;
    }

    public Venda(Cliente cliente, String observacao){
        setCliente(cliente);
        setObservacao(observacao);
        this.produtos = new ArrayList<>();   
    }

    public void setCliente(Cliente cliente){
        if(cliente == null){
            System.out.println("Cliente Inválido");
        } else {
            this.cliente = cliente;
        }
    }

    public void setObservacao(String observacao){
        if(observacao.trim().isEmpty() || observacao == null){
            System.out.println("Observação Inválido");
        } else {
            this.observacao = observacao;
        }
    }

    public void adicionarProduto(Produto produto){
        if(produto == null){
            System.out.println("Produto Inválido");
        } else if(produtos.contains(produto)) {
            System.out.println(produto + " já existe na Lista");
        } else {
            produtos.add(produto);
            System.out.println("Produto Adicionado com Sucesso!");
        }
    }

    public void listarProdutos(){
        System.out.println("=== LISTA DE PRODUTOS ===");
        if(produtos.isEmpty()){
            System.out.println("A lista está vazia");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    @Override
    public String toString(){
        return  "=== Venda ===" + 
                "\nCliente: " + cliente.getNome() + 
                "\nTotal de Compras: " + produtos.size();
    }
}
