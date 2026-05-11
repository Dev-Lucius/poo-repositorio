package poo_ex12;

public class Lampada {
    
    private String identificacao;
    private boolean ligada;
    
    public String getIdentificacao() {
        return identificacao;
    }

    public boolean isLigada() {
        return ligada;
    }

    /**
     * CONCEITO — ESTADO DO OBJETO:
     * "ligada" representa a condição atual da lâmpada.
     * Não é final pois muda via alternarEstado().
     */
    public Lampada(String identificacao){
        this.identificacao = identificacao;
        this.ligada = false;
    }

    /**
     * Alterna o Estado da Lâmpada
     */
    public void alternarEstado(){
        this.ligada = !ligada;
    }

    @Override
    public String toString(){
        return identificacao + ": " + (ligada ? "Ligada" : "Desligada");
    }
}
