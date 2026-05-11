package poo_ex12;

public class Interruptor {

    Lampada lampada;
    private String identificacao;

    public Interruptor(String identificacao){
        this.identificacao = identificacao;
    }

    public void acionar(Lampada lampada){
        if(lampada == null){
            System.out.println("Lâmpada Inválida");
        } else{
            System.out.println("[" + identificacao + "] Acionado!");
            lampada.alternarEstado(); // Aqui, delegamos a mudança para a Lâmpada
            System.out.println("→ " + lampada);
        }
    }
}
