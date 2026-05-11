package poo_ex6;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private int id;
    private String nome;

    // Um cliente pode ter um ou vários pedidos
    private List<Pedido> pedidos;

    // Construtor
    public Cliente(int id, String nome) {
        setId(id);
        setNome(nome);
        this.pedidos = new ArrayList<>();
    }

    // Setter ID
    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        this.id = id;
    }

    // Setter Nome
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
        
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    // Método para adicionar pedidos ao cliente
    public void adicionarPedido(Pedido pedido) {

        if (pedido == null) {
            throw new IllegalArgumentException("Pedido inválido");
        }

        pedidos.add(pedido);
        pedido.setCliente(this); // mantém a associação bidirecional
    }

    public void exibirCliente(){
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Quantidade de Pedidos: " + pedidos.size());

        for(Pedido pedido : pedidos){
            System.out.println("Pedido ID: " + pedido.getId());
        }
    }
}