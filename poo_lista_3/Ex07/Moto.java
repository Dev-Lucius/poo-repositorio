package Ex07;

public class Moto extends Veiculo {
    private double carga;
    private double autonomia;
    private double custoViagem;
    private final double CARGA_MAX_SUPORTADA = 100;

    public Moto(String placa, String modelo, double consumoBase, double carga) {
        super(placa, modelo, consumoBase);
        this.carga = carga;
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

    public boolean autorizarMoto() {
        if (carga > CARGA_MAX_SUPORTADA) {
            System.out.println("Moto Não Suporta Esta Carga");
            return false;
        }
        return true;
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
        if (!autorizarMoto()) {
            System.out.println("Moto Não é Capaz de Realizar Esta Viagem");
            return 0;
        } else {
            custoViagem = (distancia / consumoBase) * precoCombustivel;
        }
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
