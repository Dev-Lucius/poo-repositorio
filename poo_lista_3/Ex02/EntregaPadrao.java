package Ex02;

public class EntregaPadrao extends Entrega{
    private static final double TAXA_POR_KG = 7.0;

    public EntregaPadrao(String destinatario, double peso, double valorDeclarado){
        super(destinatario, peso, valorDeclarado);
    }

    @Override
    public double calcularFrete(){
        return peso * TAXA_POR_KG;
    }
}
