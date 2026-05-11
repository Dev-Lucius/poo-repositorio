package clinico.model.veiculo;

public class UtilitarioCarga extends Veiculo {

    private double volumeMaximoLitros;
    private boolean possuiRampaAcesso;

    public UtilitarioCarga(String placa, String modelo, double capacidadeMaximaKg,
                            double volumeMaximoLitros, boolean possuiRampaAcesso) {
        super(placa, modelo, capacidadeMaximaKg);
        this.volumeMaximoLitros = volumeMaximoLitros;
        this.possuiRampaAcesso = possuiRampaAcesso;
    }

    public double getVolumeMaximoLitros() { return volumeMaximoLitros; }
    public boolean isPossuiRampaAcesso() { return possuiRampaAcesso; }
}
