package Ex02;

public class EntregaExpressa extends Entrega{

    private static final double TAXA_POR_KG = 7.0;
    private double taxaUrgencia;

    public EntregaExpressa(String destinatario, double peso, double valorDeclarado, double taxaUrgencia){
        super(destinatario, peso, valorDeclarado);
        this.taxaUrgencia = taxaUrgencia;
    }

    @Override
    public double calcularFrete(){
        return (peso * TAXA_POR_KG) + taxaUrgencia;
    }
}
