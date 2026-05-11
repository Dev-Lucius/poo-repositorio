package clinico.model.operacao;

import clinico.enums.TipoProfissional;
import clinico.model.veiculo.VanRefrigerada;

public class TransporteMedicamentoControlado extends OperacaoClinica {

    private String nomeMedicamento;
    private boolean exigeRefrigeracao;
    private Double temperaturaMinima;
    private Double temperaturaMaxima;
    private boolean exigeAutorizacaoFarmaceutica;

    public TransporteMedicamentoControlado(String codigo, String origem, String destino,
                                            double distanciaKm, String solicitante,
                                            String nomeMedicamento,
                                            boolean exigeRefrigeracao,
                                            Double temperaturaMinima,
                                            Double temperaturaMaxima,
                                            boolean exigeAutorizacaoFarmaceutica) {
        super(codigo, origem, destino, distanciaKm, solicitante);
        this.nomeMedicamento = nomeMedicamento;
        this.exigeRefrigeracao = exigeRefrigeracao;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.exigeAutorizacaoFarmaceutica = exigeAutorizacaoFarmaceutica;
    }

    @Override
    public String getTipo() { return "Transporte de Medicamento Controlado"; }

    @Override
    public double calcularCusto() {
        double custo = 40 + getDistanciaKm() * 2.5;
        if (exigeRefrigeracao) custo += 35;
        if (exigeAutorizacaoFarmaceutica) custo += 20;
        return custo;
    }

    @Override
    public int calcularPrioridade() {
        int prioridade = 3;
        if (exigeAutorizacaoFarmaceutica) prioridade += 2;
        if (exigeRefrigeracao) prioridade += 1;
        return prioridade;
    }

    @Override
    public boolean validar() {
        if (exigeRefrigeracao) {
            if (temperaturaMinima == null || temperaturaMaxima == null) {
                System.out.println("[VALIDAÇÃO] " + getCodigo() +
                    ": exige refrigeração, mas temperaturas não informadas.");
                return false;
            }
            if (!(getVeiculoDesignado() instanceof VanRefrigerada)) {
                System.out.println("[VALIDAÇÃO] " + getCodigo() +
                    ": exige refrigeração — veículo deve ser VanRefrigerada.");
                return false;
            }
            VanRefrigerada van = (VanRefrigerada) getVeiculoDesignado();
            if (!van.temperaturaAderenteFaixa(temperaturaMinima, temperaturaMaxima)) {
                System.out.println("[VALIDAÇÃO] " + getCodigo() +
                    ": temperatura da van (" + van.getTemperaturaAtual() +
                    "°C) fora da faixa [" + temperaturaMinima + ", " + temperaturaMaxima + "].");
                return false;
            }
        }
        if (exigeAutorizacaoFarmaceutica && !equipeContemTipo(TipoProfissional.FARMACEUTICO)) {
            System.out.println("[VALIDAÇÃO] " + getCodigo() +
                ": exige autorização farmacêutica — equipe sem FARMACÊUTICO.");
            return false;
        }
        return true;
    }

    @Override
    public String obterDescricaoRastreamento() {
        return super.obterDescricaoRastreamento() +
            " | Medicamento: " + nomeMedicamento +
            (exigeRefrigeracao ? " | Refrigeração: " + temperaturaMinima + "°C–" + temperaturaMaxima + "°C" : "");
    }

    // Getters
    public String getNomeMedicamento() { return nomeMedicamento; }
    public boolean isExigeRefrigeracao() { return exigeRefrigeracao; }
    public Double getTemperaturaMinima() { return temperaturaMinima; }
    public Double getTemperaturaMaxima() { return temperaturaMaxima; }
    public boolean isExigeAutorizacaoFarmaceutica() { return exigeAutorizacaoFarmaceutica; }
}
