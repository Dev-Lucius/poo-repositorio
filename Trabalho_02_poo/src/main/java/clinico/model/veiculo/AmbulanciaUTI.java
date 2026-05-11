package clinico.model.veiculo;

public class AmbulanciaUTI extends Veiculo {

    private boolean possuiRespirador;
    private boolean possuiMonitorCardiaco;
    private boolean possuiEquipeMedicaFixa;

    public AmbulanciaUTI(String placa, String modelo, double capacidadeMaximaKg,
                          boolean possuiRespirador, boolean possuiMonitorCardiaco,
                          boolean possuiEquipeMedicaFixa) {
        super(placa, modelo, capacidadeMaximaKg);
        this.possuiRespirador = possuiRespirador;
        this.possuiMonitorCardiaco = possuiMonitorCardiaco;
        this.possuiEquipeMedicaFixa = possuiEquipeMedicaFixa;
    }

    public boolean isPossuiRespirador() { return possuiRespirador; }
    public boolean isPossuiMonitorCardiaco() { return possuiMonitorCardiaco; }
    public boolean isPossuiEquipeMedicaFixa() { return possuiEquipeMedicaFixa; }

    // UTI sempre possui oxigênio embutido
    public boolean isPossuiOxigenio() { return true; }
}
