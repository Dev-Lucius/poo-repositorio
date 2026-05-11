package clinico.model.operacao;

import clinico.enums.TipoProfissional;

public class TransporteEquipamentoMedico extends OperacaoClinica {

    private String nomeEquipamento;
    private double pesoKg;
    private double valorEstimado;
    private boolean exigeTecnicoAcompanhante;
    private boolean exigeSeguro;

    public TransporteEquipamentoMedico(String codigo, String origem, String destino,
                                        double distanciaKm, String solicitante,
                                        String nomeEquipamento, double pesoKg,
                                        double valorEstimado,
                                        boolean exigeTecnicoAcompanhante,
                                        boolean exigeSeguro) {
        super(codigo, origem, destino, distanciaKm, solicitante);
        this.nomeEquipamento = nomeEquipamento;
        this.pesoKg = pesoKg;
        this.valorEstimado = valorEstimado;
        this.exigeTecnicoAcompanhante = exigeTecnicoAcompanhante;
        this.exigeSeguro = exigeSeguro;
    }

    @Override
    public String getTipo() { return "Transporte de Equipamento Médico"; }

    @Override
    public double calcularCusto() {
        double custo = 50 + getDistanciaKm() * 1.2;
        if (pesoKg > 100) custo += 60;
        if (exigeTecnicoAcompanhante) custo += 70;
        if (exigeSeguro) custo += valorEstimado * 0.02;
        return custo;
    }

    @Override
    public int calcularPrioridade() {
        int prioridade = 3;
        if (exigeTecnicoAcompanhante) prioridade += 2;
        if (pesoKg > 100) prioridade += 1;
        return prioridade;
    }

    @Override
    public boolean validar() {
        if (pesoKg > 100) {
            if (getVeiculoDesignado() == null) {
                System.out.println("[VALIDAÇÃO] " + getCodigo() + ": nenhum veículo designado.");
                return false;
            }
            if (!getVeiculoDesignado().suportaPeso(pesoKg)) {
                System.out.println("[VALIDAÇÃO] " + getCodigo() +
                    ": peso do equipamento (" + pesoKg + "kg) excede capacidade do veículo.");
                return false;
            }
        }
        if (exigeTecnicoAcompanhante && !equipeContemTipo(TipoProfissional.TECNICO_EQUIPAMENTO)) {
            System.out.println("[VALIDAÇÃO] " + getCodigo() +
                ": exige técnico acompanhante — equipe sem TECNICO_EQUIPAMENTO.");
            return false;
        }
        return true;
    }

    @Override
    public String obterDescricaoRastreamento() {
        return super.obterDescricaoRastreamento() +
            " | Equipamento: " + nomeEquipamento +
            " (" + pesoKg + "kg, R$ " + String.format("%.2f", valorEstimado) + ")";
    }

    // Getters
    public String getNomeEquipamento() { return nomeEquipamento; }
    public double getPesoKg() { return pesoKg; }
    public double getValorEstimado() { return valorEstimado; }
    public boolean isExigeTecnicoAcompanhante() { return exigeTecnicoAcompanhante; }
    public boolean isExigeSeguro() { return exigeSeguro; }
}
