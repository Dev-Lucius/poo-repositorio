package clinico.model.veiculo;

public class VanRefrigerada extends Veiculo {

    private double temperaturaAtual;
    private final boolean suportaControleTemperatura;

    public VanRefrigerada(String placa, String modelo, double capacidadeMaximaKg,
                           double temperaturaAtual, boolean suportaControleTemperatura) {
        super(placa, modelo, capacidadeMaximaKg);
        this.temperaturaAtual = temperaturaAtual;
        this.suportaControleTemperatura = suportaControleTemperatura;
    }

    public double getTemperaturaAtual() { return temperaturaAtual; }
    public void setTemperaturaAtual(double temperaturaAtual) { this.temperaturaAtual = temperaturaAtual; }
    public boolean isSuportaControleTemperatura() { return suportaControleTemperatura; }

    public boolean temperaturaAderenteFaixa(double tempMin, double tempMax) {
        return temperaturaAtual >= tempMin && temperaturaAtual <= tempMax;
    }
}
