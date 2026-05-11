package associacao;

/**
 * Representa uma Consulta médica.
 *
 * CONCEITO — AGREGAÇÃO (Consulta x Médico x Paciente):
 * A Consulta depende de um Médico e de um Paciente para existir,
 * mas não controla o ciclo de vida deles. Se a Consulta for
 * cancelada ou removida, o Médico e o Paciente continuam existindo.
 * A Consulta apenas "agrega" (referencia) os dois objetos.
 *
 * CONCEITO — FLAG DE ESTADO:
 * O atributo "ativa" controla o estado atual da consulta.
 * true  → consulta está ativa/agendada
 * false → consulta foi cancelada
 * Isso evita remover o objeto da memória e permite, por exemplo,
 * manter um histórico de consultas canceladas.
 */
public class Consulta {

    // Referências aos objetos agregados — existem fora desta classe
    private final Medico medico;
    private final Paciente paciente;

    /**
     * CONCEITO — FLAG DE ESTADO:
     * Controla se a consulta está ativa ou cancelada.
     * Começa como true pois toda consulta é criada como ativa.
     */
    private boolean ativa;

    /**
     * Construtor da Consulta.
     *
     * CONCEITO — AGREGAÇÃO NO CONSTRUTOR:
     * Diferente da Composição (onde as partes são criadas dentro
     * do construtor), aqui recebemos objetos já existentes como
     * parâmetros. A Consulta não cria o Médico nem o Paciente —
     * apenas recebe as referências para eles.
     * Isso é a essência da Agregação.
     *
     * @param paciente Paciente da consulta. Não pode ser nulo.
     * @param medico   Médico responsável. Não pode ser nulo.
     * @throws IllegalArgumentException se qualquer parâmetro for nulo.
     */
    public Consulta(Paciente paciente, Medico medico) {
        // Validação: uma consulta sem médico ou paciente não faz sentido
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente inválido: não pode ser nulo.");
        }
        if (medico == null) {
            throw new IllegalArgumentException("Médico inválido: não pode ser nulo.");
        }

        this.paciente = paciente;
        this.medico   = medico;
        this.ativa    = true; // toda consulta começa como ativa
    }

    /**
     * Cancela a consulta.
     *
     * CONCEITO — CICLO DE VIDA INDEPENDENTE:
     * Cancelar a consulta altera apenas o estado interno deste objeto.
     * O Médico e o Paciente agregados NÃO são afetados — eles continuam
     * existindo normalmente e podem participar de outras consultas.
     * Isso é o comportamento esperado da Agregação.
     */
    public void cancelar() {
        if (!ativa) {
            // Evita cancelar uma consulta que já foi cancelada
            System.out.println("A consulta já estava cancelada.");
            return;
        }

        this.ativa = false;
        System.out.println("Consulta cancelada. " + medico + " e " + paciente + " continuam existindo.");
    }

    /**
     * Indica se a consulta está ativa.
     *
     * CONCEITO — GETTER DE BOOLEANO:
     * Por convenção Java, getters de boolean usam o prefixo "is".
     *
     * @return true se a consulta estiver ativa, false se cancelada.
     */
    public boolean isAtiva() {
        return ativa;
    }

    // Getters dos objetos agregados

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * CONCEITO — @Override toString():
     * Exibe o estado atual da consulta junto com os dados
     * dos objetos agregados — chamando o toString() de cada um.
     */
    @Override
    public String toString() {
        String status = ativa ? "ATIVA" : "CANCELADA";
        return "Consulta [" + status + "] → " + medico + " | " + paciente;
    }
}