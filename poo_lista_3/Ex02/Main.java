package Ex02;

public class Main {
    public static void main(String[] args) {

        // Casos válidos
        Entrega padrao = new EntregaPadrao("João da Silva", 3.0, 200.0);
        Entrega expressa = new EntregaExpressa("Maria Oliveira", 2.5, 350.0, 30.0);
        Entrega internacional = new EntregaInternacional("Carlos Martins", 5.0, 1000.0, 80.0, 0.08);

        padrao.gerarResumoEntrega();
        expressa.gerarResumoEntrega();
        internacional.gerarResumoEntrega();

        // Casos inválidos — frete deve ser bloqueado
        Entrega pesoZero = new EntregaPadrao("Teste Inválido", 0, 100.0);
        Entrega valorNegativo = new EntregaExpressa("Outro Inválido", 2.0, -50.0, 30.0);

        pesoZero.gerarResumoEntrega();
        valorNegativo.gerarResumoEntrega();
    }
}