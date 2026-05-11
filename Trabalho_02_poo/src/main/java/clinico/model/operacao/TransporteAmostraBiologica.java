package clinico.model.operacao;

import clinico.enums.NivelUrgencia;
import clinico.enums.TipoProfissional;

public class TransporteAmostraBiologica extends OperacaoClinica {

    private String tipoAmostra;
    private NivelUrgencia nivelUrgencia;
    private boolean riscoBiologico;
    private int prazoMaximoMinutos;

    public TransporteAmostraBiologica(String codigo, String origem, String destino,
                                       double distanciaKm, String solicitante,
                                       String tipoAmostra, NivelUrgencia nivelUrgencia,
                                       boolean riscoBiologico, int prazoMaximoMinutos) {
        super(codigo, origem, destino, distanciaKm, solicitante);
        this.tipoAmostra = tipoAmostra;
        this.nivelUrgencia = nivelUrgencia;
        this.riscoBiologico = riscoBiologico;
        this.prazoMaximoMinutos = prazoMaximoMinutos;
    }

    @Override
    public String getTipo() { return "Transporte de Amostra Biológica"; }

    @Override
    public double calcularCusto() {
        double custo = 30 + getDistanciaKm() * 2;
        if (nivelUrgencia == NivelUrgencia.ALTA)    custo += 40;
        if (nivelUrgencia == NivelUrgencia.CRITICA)  custo += 80;
        if (riscoBiologico)                          custo += 50;
        if (prazoMaximoMinutos < 60)                 custo += 25;
        return custo;
    }

    @Override
    public int calcularPrioridade() {
        return switch (nivelUrgencia) {
            case BAIXA   -> 2;
            case MEDIA   -> 4;
            case ALTA    -> 7;
            case CRITICA -> 10;
        };
    }

    @Override
    public boolean validar() {
        if (riscoBiologico && !equipeContemTipo(TipoProfissional.ENFERMEIRO)) {
            System.out.println("[VALIDAÇÃO] " + getCodigo() +
                ": risco biológico — equipe deve ter ENFERMEIRO.");
            return false;
        }
        if (nivelUrgencia == NivelUrgencia.CRITICA) {
            if (getVeiculoDesignado() == null || !getVeiculoDesignado().isDisponivel()) {
                System.out.println("[VALIDAÇÃO] " + getCodigo() +
                    ": urgência CRÍTICA exige veículo disponível.");
                return false;
            }
            if (!equipeContemTipo(TipoProfissional.MOTORISTA)) {
                System.out.println("[VALIDAÇÃO] " + getCodigo() +
                    ": urgência CRÍTICA exige MOTORISTA na equipe.");
                return false;
            }
        }
        return true;
    }

    @Override
    public String obterDescricaoRastreamento() {
        return super.obterDescricaoRastreamento() +
            " | Amostra: " + tipoAmostra +
            " | Urgência: " + nivelUrgencia +
            " | Prazo: " + prazoMaximoMinutos + "min";
    }

    // Getters
    public String getTipoAmostra() { return tipoAmostra; }
    public NivelUrgencia getNivelUrgencia() { return nivelUrgencia; }
    public boolean isRiscoBiologico() { return riscoBiologico; }
    public int getPrazoMaximoMinutos() { return prazoMaximoMinutos; }
}
