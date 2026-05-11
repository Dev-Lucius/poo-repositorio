package poo_ex6;

import java.time.LocalDate;

public class Pedido {

    private int id;
    private LocalDate dataPedido;
    private double valorTotal;
    private String status;
    private String formaPagamento;

    public int getId() {
        return id;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    // associação
    private Cliente cliente;

    public void setId(int id){
        if(id <= 0){
            throw new IllegalArgumentException("ID inválido");
        } 
        this.id = id;
    }

    public void setDataPedido(LocalDate dataPedido){
        if(dataPedido == null){
            throw new IllegalArgumentException("A data do pedido não pode ser nula.");
        } 
        else if(dataPedido.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("A data do pedido não pode ser futura.");
        } 
        this.dataPedido = dataPedido;
    }

    public void setValorTotal(double valorTotal){
        if(valorTotal <= 0){
            throw new IllegalArgumentException("Valor inválido");
        }
        this.valorTotal = valorTotal;
    }

    public void setStatus(String status){
        if(status == null || status.trim().isEmpty()){
            throw new IllegalArgumentException("Status inválido");
        }
        this.status = status;
    }

    public void setFormaPagamento(String formaPagamento){
        if(formaPagamento == null || formaPagamento.trim().isEmpty()){
            throw new IllegalArgumentException("Forma de pagamento inválida");
        }
        this.formaPagamento = formaPagamento;
    }

    public void setCliente(Cliente cliente){
        if(cliente == null){
            throw new IllegalArgumentException("Cliente Inválido");
        } else {
            this.cliente = cliente;
        }
    }

    // Construtor
    public Pedido(int id, LocalDate dataPedido, double valorTotal, String status, String formaPagamento){
        setId(id);
        setDataPedido(dataPedido);
        setValorTotal(valorTotal);
        setStatus(status);
        setFormaPagamento(formaPagamento);
    }
}