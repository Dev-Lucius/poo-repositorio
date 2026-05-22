package Ex07;

public class Caminhao extends Veiculo {
    private double carga;
    private double autonomia;
    private double custoViagem;

    public Caminhao(String placa, String modelo, double consumoBase, double carga) {
        super(placa, modelo, consumoBase);
        this.carga = carga;
    }

    public void setFatorCarga(double fator) {
        if (fator < 0.0 || fator > 1.0) {
            System.out.println("Erro: fator de carga deve estar entre 0.0 e 1.0");
            return;
        }
        this.carga = fator;
    }

    public boolean possuiCarga() {
        if (carga == 0.0) {
            System.out.println("Caminhão Não Possui Carga");
            return false;
        }
        return true;
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

        if (possuiCarga()) {
            double fatorPenalidade = 1.0 - (0.15 * carga); // ex.: carga=0.4 → fator=0.94
            autonomia = (litros * consumoBase) * fatorPenalidade;
        } else {
            autonomia = litros / consumoBase;
        }
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