package Ex07;

public abstract class Veiculo {
    protected String placa;
    protected String modelo;
    protected double consumoBase;

    public Veiculo(String placa, String modelo, double consumoBase) {
        this.placa = placa;
        this.modelo = modelo;
        this.consumoBase = consumoBase;
    }

    public abstract double calcularAutonomia(double litros);

    public abstract double calcularCustoViagem(double distancia, double precoCombustivel);

    public abstract String exibirDados();

    public abstract String getPlaca();
    public abstract String getModelo();
    public abstract double getConsumoBase();
}