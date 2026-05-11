package clinico.model.operacao;

import clinico.enums.NivelClinico;
import clinico.enums.TipoProfissional;
import clinico.model.veiculo.AmbulanciaSimples;
import clinico.model.veiculo.AmbulanciaUTI;

public class RemocaoPaciente extends OperacaoClinica {

    private String nomePaciente;
    private int idade;
    private NivelClinico nivelClinico;
    private boolean necessitaOxigenio;
    private boolean necessitaUtiMovel;
    private boolean necessitaMedicoAcompanhante;

    public RemocaoPaciente(String codigo, String origem, String destino,
                            double distanciaKm, String solicitante,
                            String nomePaciente, int idade,
                            NivelClinico nivelClinico,
                            boolean necessitaOxigenio,
                            boolean necessitaUtiMovel,
                            boolean necessitaMedicoAcompanhante) {
        super(codigo, origem, destino, distanciaKm, solicitante);
        this.nomePaciente = nomePaciente;
        this.idade = idade;
        this.nivelClinico = nivelClinico;
        this.necessitaOxigenio = necessitaOxigenio;
        this.necessitaUtiMovel = necessitaUtiMovel;
        this.necessitaMedicoAcompanhante = necessitaMedicoAcompanhante;
    }

    @Override
    public String getTipo() { return "Remoção de Paciente"; }

    @Override
    public double calcularCusto() {
        double custo = 100 + getDistanciaKm() * 4;
        if (necessitaOxigenio) custo += 30;
        if (necessitaUtiMovel) custo += 150;
        if (necessitaMedicoAcompanhante) custo += 120;
        return custo;
    }

    @Override
    public int calcularPrioridade() {
        return switch (nivelClinico) {
            case ESTAVEL    -> 3;
            case OBSERVACAO -> 5;
            case GRAVE      -> 8;
            case CRITICO    -> 10;
        };
    }

    // instanceof -> verifica o tipo real do objeto por trás da referência.
    // Mesmo que o atributo seja um Veiculo (genérico), o Java checa se, naquele momento, o objeto ali dentro é uma AmbulanciaUTI.
    // Método validar() é o nosso "filto de segurança"
    // Aqui aplicamos as regras de negócio e checamos os dados
    @Override
    public boolean validar() {
        // Paciente crítico obrigatoriamente precisa de UTI ou médico
        if (nivelClinico == NivelClinico.CRITICO && !necessitaUtiMovel && !necessitaMedicoAcompanhante) {
            System.out.println("[VALIDAÇÃO] " + getCodigo() + ": paciente CRÍTICO deve ter UTI móvel ou médico acompanhante.");
            return false;
        }

        // Verificando se o veículo escalado realemente tem a operação exigida
        if (necessitaUtiMovel && !(getVeiculoDesignado() instanceof AmbulanciaUTI)) {
            System.out.println("[VALIDAÇÃO] " + getCodigo() +
                ": necessita UTI móvel — veículo deve ser AmbulanciaUTI.");
            return false;
        }

        // Verificando o Oxigênio de formas diferentes com base no veículo
        if (necessitaOxigenio) {
            boolean veiculoTemOxigenio = false;
            if (getVeiculoDesignado() instanceof AmbulanciaUTI) {
                veiculoTemOxigenio = true;
            } else if (getVeiculoDesignado() instanceof AmbulanciaSimples amb) {
                veiculoTemOxigenio = amb.isPossuiOxigenio();
            }
            if (!veiculoTemOxigenio) {
                System.out.println("[VALIDAÇÃO] " + getCodigo() +
                    ": necessita oxigênio — veículo não possui oxigênio.");
                return false;
            }
        }

        // Validação da Equipe a partir do cruzamento do estado de saúde com o pessoal técnico disponível
        if ((nivelClinico == NivelClinico.GRAVE || nivelClinico == NivelClinico.CRITICO)
                && !equipeContemTipo(TipoProfissional.MEDICO)) {
            System.out.println("[VALIDAÇÃO] " + getCodigo() +
                ": nível clínico " + nivelClinico + " — equipe deve ter MÉDICO.");
            return false;
        }

        return true;
    }

    @Override
    public String obterDescricaoRastreamento() {
        return super.obterDescricaoRastreamento() +
            " | Paciente: " + nomePaciente + " (" + idade + " anos)" +
            " | Nível: " + nivelClinico +
            (necessitaUtiMovel ? " | UTI" : "") +
            (necessitaOxigenio ? " | O₂" : "") +
            (necessitaMedicoAcompanhante ? " | Médico" : "");
    }

    // Getters
    public String getNomePaciente() { return nomePaciente; }
    public int getIdade() { return idade; }
    public NivelClinico getNivelClinico() { return nivelClinico; }
    public boolean isNecessitaOxigenio() { return necessitaOxigenio; }
    public boolean isNecessitaUtiMovel() { return necessitaUtiMovel; }
    public boolean isNecessitaMedicoAcompanhante() { return necessitaMedicoAcompanhante; }
}
