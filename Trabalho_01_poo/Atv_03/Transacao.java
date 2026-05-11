package Atv_03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {

    private String tipo;
    private double valor;
    private LocalDateTime data;

    // Construtor de Transação
    public Transacao(String tipo, double valor){
        this.tipo = tipo;
        this.valor = valor;
        this.data = LocalDateTime.now(); // Aqui Capturamos o momento atual da transação
    }

    public String toString(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return  "[" + tipo + "] de R$" + String.format("%.2f", valor) + 
                " em " + data.format(fmt);  
    }
}
