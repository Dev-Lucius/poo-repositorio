package Ex02;

public class EntregaInternacional extends Entrega{
    private static final double TAXA_POR_KG = 7.0;
    private double taxaUrgencia;
    private double taxaAlfandegaria;

    public EntregaInternacional(String destinatario, double peso, double valorDeclarado, double taxaUrgencia, double taxaAlfandegaria){
        super(destinatario, peso, valorDeclarado);
        this.taxaUrgencia = taxaUrgencia;
        this.taxaAlfandegaria = taxaAlfandegaria;
    }

    @Override
    public double calcularFrete(){
        return(peso * TAXA_POR_KG) + taxaUrgencia + (taxaAlfandegaria);
    }
}
