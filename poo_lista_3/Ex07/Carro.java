package Ex07;

public class Carro extends Veiculo {
    private double autonomia;
    private double custoViagem;

    public Carro(String placa, String modelo, double consumoBase) {
        super(placa, modelo, consumoBase);
    }

    @Override
    public String getPlaca() {
        return placa;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public double getConsumoBase() {
        return consumoBase;
    }

    @Override
    public double calcularAutonomia(double litros) {
        if (litros <= 0) {
            System.out.println("Erro. Quantidade de Litros Inválida");
            return 0;
        }
        autonomia = litros / consumoBase;
        return autonomia;
    }

    @Override
    public double calcularCustoViagem(double distancia, double precoCombustivel) {
        if (precoCombustivel <= 0 || distancia <= 0) {
            System.out.println("Error. Dados Inválidos");
            return 0;
        }
        custoViagem = (distancia / consumoBase) * precoCombustivel;
        return custoViagem;
    }

    @Override
    public String exibirDados() {
        StringBuilder sb = new StringBuilder();
        sb.append(" [PLACA]").append(placa).append(":\n");
        sb.append(" [MODELO]").append(modelo).append(":\n");
        sb.append(" [CONSUMO BASE]").append(consumoBase).append(":\n");
        sb.append(" [AUTONOMIA]").append(autonomia).append(":\n");
        sb.append(" [CUSTO VIAGEM]").append(custoViagem).append(":\n");
        return sb.toString();
    }
}
