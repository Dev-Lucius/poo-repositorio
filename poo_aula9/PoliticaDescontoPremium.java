public class PoliticaDescontoPremium implements IPoliticaDesconto{
    
    @Override
    public float calcularDesconto(float total) {
        return total * 0.20f; 
    }

}
