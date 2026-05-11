package poo_ex6;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Cliente c1 = new Cliente(1, "João");
        Pedido p1 = new Pedido(1, LocalDate.now(), 100.0, "Pendente", "Pix");
        
        c1.adicionarPedido(p1);

        c1.exibirCliente();
    }
}
