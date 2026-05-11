package clinico.model.operacao;

import clinico.enums.StatusOperacao;
import clinico.interfaces.*;
import clinico.model.Profissional;
import clinico.model.veiculo.Veiculo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class OperacaoClinica
        implements Custeavel, Auditavel, Priorizavel, Validavel, Rastreavel {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private String codigo;
    private String origem;
    private String destino;
    private double distanciaKm;
    private String solicitante;
    private LocalDateTime dataHoraSolicitacao;
    private StatusOperacao status;
    private Veiculo veiculoDesignado;
    private List<Profissional> equipe;

    public OperacaoClinica(String codigo, String origem, String destino,
                            double distanciaKm, String solicitante) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.distanciaKm = distanciaKm;
        this.solicitante = solicitante;
        this.dataHoraSolicitacao = LocalDateTime.now();
        this.status = StatusOperacao.SOLICITADA;
        this.equipe = new ArrayList<>();
    }

    // Transições de status 
    public void aprovar() {
        if (status != StatusOperacao.SOLICITADA) {
            System.out.println("[ERROR] " + codigo + ": só pode aprovar se estiver SOLICITADA. Status atual: " + status);
            return;
        }
        status = StatusOperacao.APROVADA;
        System.out.println("[OK] " + codigo + " aprovada.");
    }

    public void iniciar() {
        if (status != StatusOperacao.APROVADA) {
            System.out.println("[ERROR] " + codigo + ": só pode iniciar se estiver APROVADA. Status atual: " + status);
            return;
        }
        if (!validar()) {
            System.out.println("[ERROR] " + codigo + ": operação inválida. Não pode ser iniciada.");
            return;
        }
        status = StatusOperacao.EM_EXECUCAO;
        System.out.println("[OK] " + codigo + " iniciada.");
    }

    public void concluir() {
        if (status != StatusOperacao.EM_EXECUCAO) {
            System.out.println("[ERROR] " + codigo + ": só pode concluir se estiver EM_EXECUCAO. Status atual: " + status);
            return;
        }
        status = StatusOperacao.CONCLUIDA;
        System.out.println("[OK] " + codigo + " concluída.");
    }

    public void cancelar() {
        if (status == StatusOperacao.CONCLUIDA) {
            System.out.println("[ERROR] " + codigo + ": não é possível cancelar uma operação CONCLUIDA.");
            return;
        }
        status = StatusOperacao.CANCELADA;
        System.out.println("[OK] " + codigo + " cancelada.");
    }

    // Implementações comuns das interfaces 
    @Override
    public String gerarLogAuditoria() {
        return String.format(
            "[AUDITORIA] %s | Tipo: %s | Status: %s | Solicitante: %s | " +
            "Rota: %s -> %s (%.1f km) | Custo: R$ %.2f | Prioridade: %d | " +
            "Solicitado em: %s | Veículo: %s | Equipe: %d profissional(is)",
            codigo, getTipo(), status, solicitante,
            origem, destino, distanciaKm,
            calcularCusto(), calcularPrioridade(),
            dataHoraSolicitacao.format(FMT),
            veiculoDesignado != null ? veiculoDesignado.getModelo() : "Não designado",
            equipe.size()
        );
    }

    @Override
    public String obterDescricaoRastreamento() {
        return String.format(
            "[RASTREAMENTO] %s (%s) | %s → %s | Status: %s",
            codigo, getTipo(), origem, destino, status
        );
    }

    // Métodos auxiliares para subclasses 
    protected boolean equipeContemTipo(clinico.enums.TipoProfissional tipo) {
        return equipe.stream().anyMatch(p -> p.getTipo() == tipo);
    }

    // Métodos abstratos que cada subclasse implementa 
    public abstract String getTipo();

    // Getters e setters 
    public String getCodigo() { return codigo; }
    public String getOrigem() { return origem; }
    public String getDestino() { return destino; }
    public double getDistanciaKm() { return distanciaKm; }
    public String getSolicitante() { return solicitante; }
    public LocalDateTime getDataHoraSolicitacao() { return dataHoraSolicitacao; }
    public StatusOperacao getStatus() { return status; }
    public Veiculo getVeiculoDesignado() { return veiculoDesignado; }
    public List<Profissional> getEquipe() { return equipe; }

    public void setVeiculoDesignado(Veiculo veiculo) { this.veiculoDesignado = veiculo; }

    public void adicionarProfissional(Profissional p) { equipe.add(p); }
}
